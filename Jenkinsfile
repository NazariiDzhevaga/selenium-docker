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
                bat 'docker build -t=nazariidoker1/docker .'
            }
        }

        stage('Push Immage') {
            environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps() {
                bat 'echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% -p --password-stdin'
                bat 'docker push nazariidoker1/docker'
            }
        }
    }
    
    post{
            always{
                bat 'docker logout'
            }
        }
}
