pipeline {

    agent {
        label 'docker'
    }

    stages {

        stage('Build Jar') {
            steps() {
                bt "mvn clean package -DskipTests"
            }
        }

        stage('Build Image') {
            steps() {
                bt "docker build nazariidoker1/docker"
            }
        }

        stage('Push Immage') {
            steps() {
                bt "docker push nazariidoker1/docker"
            }
        }

    }
}
