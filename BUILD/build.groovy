node {
    checkout scm
    def containerId
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
        containerId = sh(script: 'docker run -d java-autotests', returnStdout: true).trim()
        sh "docker exec ${containerId} gradle test"
    }
    stage('Copy Allure Results') {
        sh "docker cp ${containerId}:/app/build/allure-results ${WORKSPACE}/allure-results"
        sh "docker rm -f ${containerId}"
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
