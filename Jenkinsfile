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
                bat 'docker build -t=nazariidoker1/docker:latest .'
            }
        }

        stage('Push Immage') {
            environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps() {
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat 'docker push nazariidoker1/docker:latest'
                bat "docker tag nazariidoker1/docker:latest nazariidoker1/docker:%env.BUILD_NUMBER%"
                bat 'docker push nazariidoker1/docker:%env.BUILD_NUMBER%'
            }
        }
    }

    post{
        always{
            bat 'docker logout'
        }
    }
}
