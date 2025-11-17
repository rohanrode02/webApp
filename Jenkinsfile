pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'github-token-mini', url: 'https://github.com/rohanrode02/webApp.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t webapp:1.0 .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 9000:80 --name webapp webapp:1.0'
            }
        }
    }
}
