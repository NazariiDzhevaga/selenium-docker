pipeline {

    agent any

    stages {

        stage('Build Jar') {
            steps() {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps() {
                sh 'docker build nazariidoker1/docker'
            }
        }

        stage('Push Immage') {
            steps() {
                sh 'docker push nazariidoker1/docker'
            }
        }

    }
}
