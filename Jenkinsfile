pipeline {
    agent any

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
        stage('clean') {
            steps {
                // Build your project
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                // Run unit tests
                bat 'mvn test'
            }
        }

         stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'Sonar_Default'
                    withSonarQubeEnv('SonarQubeServer') {
					 withCredentials([string(credentialsId: 'sonarqube-token', variable: 'Sonar_Token')]) {
                        sh "${scannerHome}/bin/sonar-scanner"
						}
                    }
                }
            }
        }

         stage('Package') {
                    steps {
                        // Run unit tests
                        bat 'mvn package'
                    }
         }
    }
    post {
       success {
                           junit '**/target/surefire-reports/TEST-*.xml'
                           archiveArtifacts 'target/*.jar'
                 }
    }
}
