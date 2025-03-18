pipeline {
    agent any

    stages {
        // Stage 1: Checkout the code
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Ajmalk2002/Wipro-Capstone.git'
            }
        }

        // Stage 2: Build the project
        stage('Build') {
            steps {
                bat 'mvn clean install' // Use 'bat' instead of 'sh' for Windows
            }
        }

        // Stage 3: Run tests
        stage('Test') {
            steps {
                bat 'mvn test' // Use 'bat' instead of 'sh' for Windows
            }
            post {
                always {
                    // Publish test results
                    junit '**/target/surefire-reports/*.xml'
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
                    reportDir: 'target/site/surefire-report', // Corrected the path
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
