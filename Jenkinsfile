pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Build your project
                sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                // Run unit tests
                sh 'mvn test'
            }
        }

         stage('Test') {
                    steps {
                        // Run unit tests
                        sh 'mvn package'
                    }
         }

        stage('SonarQube Analysis') {
            steps {
                    sh 'mvn sonar:sonar'
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
