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

          stage('jacoco') {
            steps {
                // Run unit tests
                bat 'mvn jacoco:report'
            }
        }

        

        
		stage('Sonarqube') {
			environment {
				scannerHome = tool 'Sonar_Scanner_Default'
			}
			steps {
				withSonarQubeEnv('Sonar_Server_Default') {
					 withCredentials([string(credentialsId: 'Sonar_Token', variable: 'User_Sonar_Token')]) {
								
					bat "${scannerHome}/bin/sonar-scanner \
					-Dsonar.projectKey=LearnJenkins_V1 \
					-Dsonar.java.binaries=target/classes \
					-Dsonar.sources=src \
					 -Dsonar.login=\${User_Sonar_Token} \
					-Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml"
							   
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
    

		stage('Trigger Mail'){
			steps{
				 mail to: 'bhavesh.rd09@gmail.com',
					 subject: 'Build Notification',
					 body: "Build successful. Build details:\n\n" +
						 + "Build Number: ${BUILD_NUMBER}\n" +
						 + "Project Name: ${PROJECT_NAME}\n" +
						 + "Build Status: ${BUILD_STATUS}\n" +
						 + "Build URL : ${BUILD_URL}\n", 
					 from: 'rbhaveshgm.0908@gmail.com'
			}
		}
    }
}
