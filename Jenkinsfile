pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('Sonar_Token_Updated')
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
            bat "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=LearnJenkins_V1 \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.sources=src \
             -Dsonar.login=${env.SONAR_TOKEN}"
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
