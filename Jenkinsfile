pipeline {
    agent any

  

     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
    }
    
    stages {
		stage('Trigger Mail'){
			steps{
 def to = emailextrecipients([
           requestor()
    ])
    
    // set variables
    def subject = "${env.JOB_NAME} - Build #${env.BUILD_NUMBER} ${result}"
    
			steps{
			 if(to != null && !to.isEmpty()) {
					emailext(body: content, mimeType: 'text/html',
					subject: subject,
					to: to, attachLog: true )
    }
			}
		}
		}
    }
}
