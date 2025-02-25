pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "georgesmomo/youtube-backend"
    }

    options {
        // Définir un répertoire de travail global pour le pipeline
        workdir 'youtubeapp'  // Ce répertoire sera utilisé par toutes les étapes
    }

    stages {
        stage('Cloner le code') {
            steps {
                sh 'rm -rf ./*'  // Nettoyage du répertoire avant le clone
                sh 'git clone https://github.com/georgesmomo/youtubeapp.git'  // Clonage du code
            }
        }

        stage('Créer Image Docker Backend') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'  // Création de l'image Docker dans le répertoire youtubeapp
            }
        }

        stage('Pousser Image Docker Backend') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub_credentials', url: '']) {
                    sh 'docker push $DOCKER_IMAGE'  // Poussée de l'image Docker vers Docker Hub
                }
            }
        }

        stage('Déploiement Backend') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'  // Déploiement avec Ansible
            }
        }
    }
}
