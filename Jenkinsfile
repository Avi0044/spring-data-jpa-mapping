pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Avi0044/spring-data-jpa-mapping.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                    chmod +x mvnw
                    export MAVEN_OPTS="-Xmx384m -XX:MaxMetaspaceSize=128m"
                    ./mvnw clean package -DskipTests
                '''
            }
        }

        stage('Check JAR') {
            steps {
                sh '''
                    ls -lh target/spring-data-jpa-mapping-0.0.1-SNAPSHOT.jar
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    scp \
                    -i /var/lib/jenkins/.ssh/id_ed25519 \
                    -o IdentitiesOnly=yes \
                    -o StrictHostKeyChecking=accept-new \
                    target/spring-data-jpa-mapping-0.0.1-SNAPSHOT.jar \
                    ubuntu@13.211.200.230:/tmp/mapping-service.jar

                    ssh \
                    -i /var/lib/jenkins/.ssh/id_ed25519 \
                    -o IdentitiesOnly=yes \
                    -o StrictHostKeyChecking=accept-new \
                    ubuntu@13.211.200.230 \
                    'sudo /usr/local/bin/deploy-mapping.sh'
                '''
            }
        }

        stage('Health Check') {
            steps {
                sh '''
                    ssh \
                    -i /var/lib/jenkins/.ssh/id_ed25519 \
                    -o IdentitiesOnly=yes \
                    -o StrictHostKeyChecking=accept-new \
                    ubuntu@13.211.200.230 \
                    'curl -fsS http://127.0.0.1:8899/swagger-ui/index.html >/dev/null'
                '''
            }
        }
    }
}