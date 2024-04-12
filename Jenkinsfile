pipeline {
    agent any

environment {
        SONAR_TOKEN = credentials('Sonar_Token')
    }
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
                    def scannerHome = tool 'Sonar_Scanner_Default'
                    withSonarQubeEnv('Sonar_Server_Default') {
					 withCredentials([string(credentialsId: 'Sonar_Token', variable: 'SONAR_TOKEN')]) {
                        sh "${scannerHome}/bin/sonar-scanner \
				-Dsonar.login=${env.SONAR_TOKEN}"
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
