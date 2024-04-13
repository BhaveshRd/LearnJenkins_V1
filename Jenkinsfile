pipeline {
    agent any

  

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
             withCredentials([string(credentialsId: 'Sonar_Token', variable: 'Sonar_Token_Updated')]) {
                        
            bat "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=LearnJenkins_V1 \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.sources=src \
             -Dsonar.host.url=http://localhost:9000 \    
             -Dsonar.token=\${Sonar_Token_Updated}"
             }
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
}
