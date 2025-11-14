pipeline {
    agent any

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/rohanrode02/webApp.git'
            }
        }

        stage('Maven Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t webapp:1.0 .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker rm -f webapp_container || ver > nul'
                bat 'docker run -d -p 9090:9090 --name webapp_container webapp:1.0'
            }
        }
    }
}
