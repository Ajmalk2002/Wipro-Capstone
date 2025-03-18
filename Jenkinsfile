pipeline {
    agent any

    stages {
        // Stage 1: Checkout the code
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ajmalk2002/wipro-capstoneproject/tree/main/Capstone_Project_DemoWebShop_Automation'
            }
        }

        // Stage 2: Build the project
        stage('Build') {
            steps {
                sh 'mvn clean install' // For Maven projects
                // sh 'gradle build'   // For Gradle projects
            }
        }

        // Stage 3: Run tests
        stage('Test') {
            steps {
                sh 'mvn test' // For Maven projects
                // sh 'gradle test' // For Gradle projects
            }
            post {
                always {
                    // Publish test results
                    junit '**/target/surefire-reports/*.xml' // For Maven projects
                    // junit '**/build/test-results/test/*.xml' // For Gradle projects
                }
            }
        }

        // Stage 4: Publish HTML reports
        stage('Publish Reports') {
            steps {
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/site/surefire-report.html', // Path to your HTML report
                    reportFiles: 'index.html',
                    reportName: 'Test Report'
                ]
            }
        }
    }

    post {
        failure {
            echo 'Pipeline failed! Sending notification...'
            // Add notification steps (e.g., email, Slack)
        }
        success {
            echo 'Pipeline succeeded!'
        }
    }
}