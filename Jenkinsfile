pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
	
	
	post {
        success {
            echo "Build successful!"
            currentBuild.result = 'SUCCESS'
        }
        failure {
            echo "Build failed!"
            currentBuild.result = 'FAILURE'
        }
    }
    
	if (currentBuild.result != null) {
		emailext body : "Your Jenkins build  #${BUILD_NUMBER} has a build status #${currentBuild.result}. You can check git commit id : ${GIT_COMMIT}",
				subject: "Jenkins Build Notification",
				to: 'bhavesh.rd09@gmail.com'
} 

 
}
