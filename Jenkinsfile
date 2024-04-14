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
                bat 'mvn clean test'
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
						 + "Build Number: ${env.BUILD_NUMBER}\n" +
						 + "Project Name: ${env.PROJECT_NAME}\n" +
						 + "Build Status: ${env.BUILD_STATUS}\n" +
						 + "Build URL : ${env.BUILD_URL}\n", 
					 from: 'rbhaveshgm.0908@gmail.com'
			}
		}
    }
}
