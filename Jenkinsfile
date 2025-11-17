pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/rohanrode02/webApp.git', credentialsId: 'github-token-mini'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t webapp:1.0 .'
            }
        }

        stage('Run Container') {
            steps {
                bat '''
                docker stop webapp || true
                docker rm webapp || true
                docker run -d -p 9000:8080 --name webapp webapp:1.0
                '''
            }
        }
    }
}
