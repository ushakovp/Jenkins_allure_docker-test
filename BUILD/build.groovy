node {
    checkout scm
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
            sh "docker run --rm -v ${WORKSPACE}/allure-results:/app/build/allure-results java-autotests gradle test"
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
