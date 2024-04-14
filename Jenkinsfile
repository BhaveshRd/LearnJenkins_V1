pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
		stage('Trigger Mail'){
			steps{
				 emailext body : "${currentBuild.currentResult}:* Job Name: 
		                ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More 
		                information at: ${env.BUILD_URL}",
				subject: 'Declarative Pipeline Build Status',
				to: 'bhavesh.rd09@gmail.com'
			}
		}
    }
}
