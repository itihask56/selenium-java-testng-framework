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
            choices:['Regression','Smoke','Parallel'],
            description:'Select Test Suite'
        )
    }

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }
    environment {
//        QA_BDNO_TOKEN = credentials('QA_BDNO_TOKEN')
//        QA_CRT_TOKEN  = credentials('QA_CRT_TOKEN')
//        QA_SNO_TOKEN = credentials('QA_SNO_TOKEN')
        EMOHA_UI_USERNAME = credentials('EMOHA_UI_USERNAME')
        EMOHA_UI_PASSWORD = credentials('EMOHA_UI_PASSWORD')
        EMOHA_UI_MOBILE   = credentials('EMOHA_UI_MOBILE')
        EMOHA_UI_OTP      = credentials('EMOHA_UI_OTP')
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

                    def suiteToRun = params.SUITE

                    def cause = currentBuild.getBuildCauses()[0].shortDescription

                    if (cause.contains('GitHub push')) {
                        suiteToRun = 'Smoke'
                        echo "GitHub Push Detected -> Running Smoke Suite"
                    }

                    if (cause.contains('Started by timer')) {
                        suiteToRun = 'Regression'
                        echo "Nightly Build Detected -> Running Regression Suite"
                    }

                    echo "Environment: ${params.ENV}"
                    echo "Suite: ${suiteToRun}"

                    if (suiteToRun == 'Smoke') {

                        sh """
                            mvn clean test \
                            -Denv=${params.ENV} \
                            -DsuiteXmlFile=testng/testng-smoke.xml
                        """

                    } else if (suiteToRun == 'Regression') {

                        sh """
                            mvn clean test \
                            -Denv=${params.ENV} \
                            -DsuiteXmlFile=testng/testng-regression.xml
                        """

                    } else {

                        sh """
                            mvn clean test \
                            -Denv=${params.ENV} \
                            -DsuiteXmlFile=testng/testng-parallel.xml
                        """

                    }
                }
            }
        }

    }

    post {

        always {
             archiveArtifacts artifacts: 'test-output/**', allowEmptyArchive: true


                     publishHTML([
                         allowMissing: false,
                         alwaysLinkToLastBuild: true,
                         keepAll: true,
                         reportDir: 'test-output',
                         reportFiles: 'ExtentReport.html',
                         reportName: 'Extent Report'
                     ])



        }

        success {

            emailext(
                subject: "SUCCESS: Automation Build #${BUILD_NUMBER}",
                body: """
                        Build Successful

                        Environment: ${params.ENV}
                        Suite: ${params.SUITE}

                        Build URL:
                        ${BUILD_URL}

                        Extent Report:
                        ${BUILD_URL}Extent_Report/
                """,
                to: "dev.itihasverma@gmail.com"
            )

            echo 'Build Successful'
        }

        failure {

            emailext(
                subject: "FAILED: Automation Build #${BUILD_NUMBER}",
                body: """
                        Build Failed

                        Environment: ${params.ENV}
                        Suite: ${params.SUITE}

                        Build URL:
                        ${BUILD_URL}

                        Console Logs:
                        ${BUILD_URL}console
                """,
                to: "dev.itihasverma@gmail.com"
            )

            echo 'Build Failed'
        }
    }
}

//
//
//
//pipeline {
//    agent any
//
//    tools {
//        jdk 'JDK21'
//        maven 'Maven3'
//    }
//
//    environment {
//        // API tokens are not required for the current UI-only workflow.
//        // QA_BDNO_TOKEN = credentials('QA_BDNO_TOKEN')
//        // QA_CRT_TOKEN  = credentials('QA_CRT_TOKEN')
//        // QA_SNO_TOKEN  = credentials('QA_SNO_TOKEN')
//        // PROD_BDNO_TOKEN = credentials('PROD_BDNO_TOKEN')
//        // PROD_CRT_TOKEN  = credentials('PROD_CRT_TOKEN')
//
//        EMOHA_UI_USERNAME = credentials('EMOHA_UI_USERNAME')
//        EMOHA_UI_PASSWORD = credentials('EMOHA_UI_PASSWORD')
//        EMOHA_UI_MOBILE   = credentials('EMOHA_UI_MOBILE')
//        EMOHA_UI_OTP      = credentials('EMOHA_UI_OTP')
//    }
//
//    stages {
//        stage('Checkout') {
//            steps {
//                checkout scm
//            }
//        }
//
//        stage('Verify Environment') {
//            steps {
//                sh 'java -version'
//                sh 'mvn -version'
//            }
//        }
//
//        stage('Run Emoha UI Test') {
//            steps {
//                sh 'mvn clean test -Dtest=EmohaLoginTest'
//            }
//        }
//    }
//
//    post {
//        always {
//            archiveArtifacts(
//                    artifacts: 'test-output/**, target/surefire-reports/**',
//                    allowEmptyArchive: true
//            )
//
//            publishHTML([
//                    allowMissing: true,
//                    alwaysLinkToLastBuild: true,
//                    keepAll: true,
//                    reportDir: 'test-output',
//                    reportFiles: 'ExtentReport.html',
//                    reportName: 'Extent Report'
//            ])
//        }
//
//        success {
//            emailext(
//                    subject: "SUCCESS: Emoha UI Build #${BUILD_NUMBER}",
//                    body: """
//Build Successful
//
//Test: EmohaLoginTest
//
//Build URL:
//${BUILD_URL}
//
//Extent Report:
//${BUILD_URL}Extent_Report/
//""",
//                    to: "dev.itihasverma@gmail.com"
//            )
//
//            echo 'Emoha UI test passed'
//        }
//
//        failure {
//            emailext(
//                    subject: "FAILED: Emoha UI Build #${BUILD_NUMBER}",
//                    body: """
//Build Failed
//
//Test: EmohaLoginTest
//
//Build URL:
//${BUILD_URL}
//
//Console Logs:
//${BUILD_URL}console
//""",
//                    to: "dev.itihasverma@gmail.com"
//            )
//
//            echo 'Emoha UI test failed'
//        }
//    }
//}
