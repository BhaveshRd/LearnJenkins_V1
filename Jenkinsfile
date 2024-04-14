pipeline {
    agent any
    tools {
        maven 'Maven_Default'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
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
        script {
            if (currentBuild.result != null) {
                emailext body: "Your Jenkins build #${BUILD_NUMBER} has a build status ${currentBuild.result}. You can check git commit id: ${GIT_COMMIT}",
                    subject: "Jenkins Build Notification",
                    to: 'bhavesh.rd09@gmail.com'
            }
        }
    }
}
