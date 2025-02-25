pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "georgesmomo/youtube-backend"
    }

    stages {
        stage('Cloner le code') {
            steps {
                sh 'rm -rf ./*'  // Nettoyage du répertoire avant le clone
                sh 'git clone https://github.com/georgesmomo/youtubeapp.git'  // Clonage du code
            }
        }
        stage('Build & Test Backend') {
            steps {
                dir('./youtubeapp') {
                    // Nous restons dans le répertoire './youtubeapp' pendant toute la durée de ce bloc
                    sh 'pwd'  // Cela va afficher le chemin absolu du répertoire dans lequel tu es
                    sh 'mvn clean package -DskipTests'  // Ignore les tests et fait le package
                    sh 'ls -la target'  // Vérifie si le dossier target a bien été créé et si le fichier JAR est présent
                }
            }
        }

        
        stage('Créer Image Docker Backend') {
            steps {
                dir('youtubeapp') {  // Nous changeons de répertoire pour travailler dans youtubeapp
                    sh 'docker build -t $DOCKER_IMAGE .'  // Création de l'image Docker dans le bon répertoire
                }
            }
        }

        stage('Pousser Image Docker Backend') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub_credentials', url: '']) {
                    dir('youtubeapp') {  // Nous restons dans le répertoire youtubeapp pour pousser l'image
                        sh 'docker push $DOCKER_IMAGE'  // Poussée de l'image Docker vers Docker Hub
                    }
                }
            }
        }

        stage('Déploiement Backend') {
            steps {
                dir('youtubeapp') { 
                    sh 'whoami'
                    sh 'ansible-playbook -i inventory deploy.yml'  // Déploiement avec Ansible
                }
            }
        }
    }
}
