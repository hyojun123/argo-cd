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
                        sh './mvnw clean compile jib:build -Djib.to.tags=dev.v$BUILD_NUMBER'
                        sh 'sudo helm upgrade test-boot /home/hjchoi/kuber/test-boot/ --set image.tag="dev.v$BUILD_NUMBER"'
                    }
                }
                stage('Production') {
                    when {
                        anyOf {branch 'master'}
                    }
                    steps {
                        sh './mvnw clean compile jib:build -Djib.to.tags=prod.v$BUILD_NUMBER'
                    }
                }
            }
        }
    }
}