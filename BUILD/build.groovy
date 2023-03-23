node {
    checkout scm
    stage('Build Docker Image') {
        sh "docker build -t java-autotests -f Dockerfile ."
    }
    stage('Run Tests') {
            sh 'docker run --rm -u $(id -u jenkins):$(id -g jenkins) -v ${WORKSPACE}/allure-results:/app/build/allure-results -e HOME=/home/jenkins -e USER=jenkins -w /home/jenkins java-autotests bash -c "groupadd -g $(id -g jenkins) jenkins && useradd -u $(id -u jenkins) -g $(id -g jenkins) -d /home/jenkins -m -s /bin/bash jenkins && chown -R jenkins:jenkins /app/build/allure-results && su jenkins -c \"gradle test\""'
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
