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
					 body: ${env.BUILD_NUMBER}, 
					 from: 'rbhaveshgm.0908@gmail.com'
			}
		}
    }
}
