node {
    checkout scm
    def containerId
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
        containerId = sh(script: 'docker run --name my-container java-autotests gradle test', returnStdout: true).trim()
    }
    stage('Copy Allure Results') {
        sh "docker cp my-container:/app/build/allure-results ${WORKSPACE}/allure-results"
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
