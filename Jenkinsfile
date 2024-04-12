pipeline {
    agent any
     tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
        }

    stages {
        stage('clean') {
            steps {
                // Build your project
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                // Run unit tests
                bat 'mvn test'
            }
        }

         stage('Package') {
                    steps {
                        // Run unit tests
                        bat 'mvn package'
                    }
         }
    }
    post {
       success {
                           junit '**/target/surefire-reports/TEST-*.xml'
                           archiveArtifacts 'target/*.jar'
                 }
    }
}
