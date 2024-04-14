pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
	    stage('Trigger Mail'){
				steps{
				 emailext to: 'bhavesh.rd09@gmail.com',
					 subject: 'Build Notification',
					 body: "Build details:\n\n" +
						 + "Build Number: ${BUILD_NUMBER}\n" +
						 + "Build Status: ${BUILD_STATUS}\n" +
						 + "Build URL : ${BUILD_URL}\n", 
					 from: 'rbhaveshgm.0908@gmail.com'
			}
			
			} 
    }
}
