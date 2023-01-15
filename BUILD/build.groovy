pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                    sh 'gradle test -Djavax.net.ssl.trustStore=$JAVA_HOME/lib/security/cacerts -Djavax.net.ssl.trustStorePassword=changeit'
            }
        }
    }
}
