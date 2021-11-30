pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
            }
        }
        stage('Deployment') {
            parallel {
                stage('Dev') {
                    when {
                        anyOf {branch 'develop'}
                    }
                    steps {
                        sh './mvnw clean compile jib:build -Djib.to.tags=dev:$BUILD_NUMBER'
                    }
                }
                stage('Production') {
                    when {
                        anyOf {branch 'master'}
                    }
                    steps {
                        sh './mvnw clean compile jib:build -Djib.to.tags=prod:$BUILD_NUMBER'
                    }
                }
            }
        }
    }
}