pipeline {
    agent any

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/rohanrode02/student-app.git'
            }
        }

        stage('Compile Java') {
            steps {
                bat 'javac src/*.java -d output'
            }
        }

        stage('Build Docker') {
            steps {
                bat 'docker build -t student-app:1.0 .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker rm -f student_container || ver > nul'
                bat 'docker run -d -p 8080:8080 --name student_container student-app:1.0'
            }
        }
    }
}
