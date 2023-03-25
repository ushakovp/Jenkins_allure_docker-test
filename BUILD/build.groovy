node {
    checkout scm
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
        try {
            sh "docker run --name my-container java-autotests gradle test"
        } catch (err) {
            currentBuild.result = 'FAILURE'
            throw err
        } finally {
            sh "docker cp my-container:/app/build/allure-results ${WORKSPACE}"
            sh "docker rm -f my-container"
        }
    }
    stage('Reports') {
        allure([
                includeProperties: false,
                jdk              : '',
                properties       : [],
                reportBuildPolicy: 'ALWAYS',
                results          : [[path: "allure-results"]]
        ])
    }
}
