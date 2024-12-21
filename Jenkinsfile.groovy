pipeline {
    agent {
        label "docker-agent-maven"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}