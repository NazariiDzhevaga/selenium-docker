pipeline {

    agent {
        label 'docker'
    }

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
            environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps() {
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push nazariidoker1/docker"
            }
        }

        post{
            always{
                bat 'docker logout'
            }
        }
    }
}
