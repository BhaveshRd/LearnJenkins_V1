pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
	    stage('Trigger Mail'){
				steps{
				 emailext body : "Your Jenkins build  #${BUILD_NUMBER} has a build status #$currentBuild.result. You can check git commit id : ${GIT_COMMIT}",
				subject: "Jenkins Build Notification",
				to: 'bhavesh.rd09@gmail.com'
			}
			
			} 
    }
}
