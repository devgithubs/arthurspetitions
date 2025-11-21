pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Getting code from GitHub..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Running Maven Build..."
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo "Running Tests..."
                sh 'mvn test'
            }
        }

        stage('Package WAR') {
            steps {
                echo "Packaging WAR file..."
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/arthurspetitions.war', fingerprint: true
            }
        }

        stage('Approval to Deploy') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    input message: "Deploy Arthur's Web App to Tomcat?"
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo "Deploying WAR to Tomcat Docker container..."

                // Copy WAR into Tomcat's webapps folder
                sh '''
                CONTAINER_ID=$(docker ps -qf "name=tomcat")
                docker cp target/arthurspetitions.war $CONTAINER_ID:/usr/local/tomcat/webapps/
                '''
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
