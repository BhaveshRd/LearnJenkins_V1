pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
	    stage('Trigger Mail'){
				steps{
				emailext body: "Your Jenkins build #${BUILD_NUMBER} has failed! Commit: ${GIT_COMMIT}",
              				  subject: "Build Failed",
               			 to: "bhavesh.rd09@gmail.com"
			}
			
			} 
    }
}
