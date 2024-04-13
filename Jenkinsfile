pipeline {
    agent any

environment {
        SONAR_TOKEN = credentials('Sonar_Token')
    }
     tools {
        // Specify the Maven installation to use
        maven 'Maven_Default'
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

        
stage('Sonarqube') {
    environment {
        scannerHome = tool 'Sonar_Scanner_Default'
    }
    steps {
        withSonarQubeEnv('Sonar_Server_Default') {
            bat "${scannerHome}/bin/sonar-scanner"
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
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
