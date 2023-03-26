node {
    checkout scm
    stage('Download Dependencies') {
        sh "gradle dependencies"
    }
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
        try {
            sh "docker run --name my-container java-autotests gradle test"
        } catch (ignored) {
            currentBuild.result = 'FAILURE'
        }
    }
    stage('Copy Allure Results'){
        try{
            sh "docker cp my-container:/app/build/allure-results ${WORKSPACE}"
        }catch (ignored) {
            currentBuild.result = 'FAILURE'
        }
    }
    stage('Remove container'){
        sh "docker rm -f my-container"
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
