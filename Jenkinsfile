pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }
    environment {
        API_TOKEN = credentials('API_TOKEN')
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

    }

    post {

        always {
            archiveArtifacts artifacts: 'test-output/**', allowEmptyArchive: true
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}