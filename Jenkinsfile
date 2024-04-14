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
        success {
            buildStatusNotification('SUCCESS')
        }
        failure {
            buildStatusNotification('FAILURE')
        }
    }
}

def buildStatusNotification(String buildStatus) {
    echo "Build ${buildStatus.toLowerCase()}!"
    currentBuild.result = buildStatus
    if (buildStatus in ['SUCCESS', 'FAILURE']) {
        emailext body: "Your Jenkins build #${BUILD_NUMBER} has a build status ${buildStatus}. You can check git commit id: ${GIT_COMMIT}. \n"+
	" Please check Jenkins URL for complete detail ${BUILD_URL} \n",
        subject: "Jenkins Build Notification",
            to: 'bhavesh.rd09@gmail.com'
    }
}
