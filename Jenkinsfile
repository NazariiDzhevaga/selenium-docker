pipeline {

    agent any

    stages {

        stage('Build Jar') {
            steps() {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps() {
                bat 'docker build nazariidoker1/docker'
            }
        }

        stage('Push Immage') {
            steps() {
                bat 'docker push nazariidoker1/docker'
            }
        }

    }
}
