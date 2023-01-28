node {
    checkout scm
    def customImage
    stage('Build Docker Image') {
        customImage = docker.build("java-autotests", "-f Dockerfile .")
    }
    stage('Run Tests') {
        customImage.inside {
            sh "gradle test"
        }
    }
    stage('Copy Allure Results') {
        sh "docker cp ${customImage.id}:/app/build/allure-results ${WORKSPACE}/allure-results"
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