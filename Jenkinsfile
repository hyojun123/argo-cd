pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh 'sudo ./mvnw jib:dockerBuild'
            }
        }
        stage('Deployment') {
            parallel {
                stage('Dev') {
                    when {
                        anyOf {branch 'develop'}
                    }
                    steps {
                        sh 'docker run -dit -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" chlgkwk/argo-cd'
                    }
                }
                stage('Production') {
                    when {
                        anyOf {branch 'master'}
                    }
                    steps {
                        sh 'docker run -dit -p 8081:8080 -e "SPRING_PROFILES_ACTIVE=prd" chlgkwk/argo-cd'
                    }
                }
            }
        }
    }
}