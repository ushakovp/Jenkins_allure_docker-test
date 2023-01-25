//pipeline {
//    agent any
//    stages {
//        stage('Build') {
//            steps {
//                sh 'gradle test -Djavax.net.ssl.trustStore=$JAVA_HOME/lib/security/cacerts -Djavax.net.ssl.trustStorePassword=changeit'
//            }
//        }
//    }
//}
node {
    checkout scm
    stage('Build') {
        sh 'gradle test -g gradle-user-home -Djavax.net.ssl.trustStore=$JAVA_HOME/lib/security/cacerts -Djavax.net.ssl.trustStorePassword=changeit'
    }
    stage('Reports') {
        allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'blblblbllbb']]
        ])
    }
}