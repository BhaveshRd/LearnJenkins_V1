pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
		stage('Trigger Mail'){
			steps{
				 mail to: 'bhavesh.rd09@gmail.com',
					 subject: 'Build Notification',
					 body: "Build details:\n\n" +
						 + "Build Number: ${env.BUILD_NUMBER}\n" +
						 + "Build Status: ${env.BUILD_STATUS}\n" +
						 + "Build URL : ${env.BUILD_URL}", 
					 from: 'rbhaveshgm.0908@gmail.com'
			}
		}
    }
}
