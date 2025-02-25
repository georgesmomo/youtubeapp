pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "georgesmomo/youtube-backend"
    }

    stages {
        stage('Cloner le code') {
            steps {
                sh 'rm -rf ./*'
                sh 'git clone https://github.com/georgesmomo/youtubeapp.git'
            }
        }

        stage('Build & Test Backend') {
            steps {
                dir('./youtubeapp') {
                    // Nous restons dans le répertoire './youtubeapp' pendant toute la durée de ce bloc
                    sh 'pwd'  // Cela va afficher le chemin absolu du répertoire dans lequel tu es
                    sh 'mvn clean package'
                    sh 'mvn test'
                }
            }
        }

        stage('Créer Image Docker Backend') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Pousser Image Docker Backend') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub_credentials', url: '']) {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Déploiement Backend') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'
            }
        }
    }
}
