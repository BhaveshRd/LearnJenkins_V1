
pipeline {
    agent any
    tools {
        maven 'Maven_Default'
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
    }
    post {
        always {
            script {
                // Send email based on build result with default subject and body
                emailext (
                    subject: emailextdefaultsubject(),
                    body: emailextdefaultbody(),
                    to: emailextrecipients([[$class: 'DefaultRecipientProvider']])
                )
            }
        }
    }
}
