pipeline {

    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(
            logRotator(
                numToKeepStr: '10'
            )
        )
    }

    stages {

        stage('Build & Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw -B clean test'
            }
        }

        stage('Package') {
            steps {
                sh './mvnw -B package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker compose --env-file /opt/spring-data-jpa-mapping/.env build app'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker compose \
                    --env-file /opt/spring-data-jpa-mapping/.env \
                    up -d app
                '''
            }
        }

        stage('Smoke Test') {
            steps {
                sh '''
                    sleep 10
                    curl -f http://127.0.0.1:8899/api/v1/user/
                '''
            }
        }
    }

    post {

        success {
            echo 'Deployment successful!'
        }

        failure {
            sh 'docker compose --env-file /opt/spring-data-jpa-mapping/.env ps || true'
            sh 'docker compose --env-file /opt/spring-data-jpa-mapping/.env logs --tail=100 app || true'
        }
    }
}