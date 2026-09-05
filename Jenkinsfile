pipeline {

    agent any
    parameters {
        choice(
            name:'ENV',
            choices:['QA','UAT'],
            description:'Select Environment'
        )

        choice(
            name:'SUITE',
            choices:['Smoke','Regression'],
            description:'Select Test Suite'
        )
    }

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

                script {

                    echo "Environment: ${params.ENV}"
                    echo "Suite: ${params.SUITE}"

                    if (params.SUITE == 'Smoke') {

                        sh """
                            mvn clean test \
                            -Denv=${params.ENV} \
                            -DsuiteXmlFile=testng/testng-smoke.xml
                        """

                    } else {

                        sh """
                            mvn clean test \
                            -Denv=${params.ENV} \
                            -DsuiteXmlFile=testng/testng-regression.xml
                        """

                    }

                }

            }

        }

    }

    post {

        always {
             archiveArtifacts artifacts: 'reports/**', allowEmptyArchive: true
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