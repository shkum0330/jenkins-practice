pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/shkum0330/jenkins-practice', branch: 'main'
            }
        }
        
    
        stage("Package") {
            steps {
                dir('calculator') {
                    sh "./gradlew build"
                }
            }
        }   

        stage("Docker build") {
            steps {
                dir('calculator') {
                    sh "docker build --platform linux/amd64 -t calculator ."
                }
            }
        }

        stage('Unit test'){
            steps{
                dir('calculator') {
                    sh "./gradlew test"
                }
            }
        }
        stage("Code coverage") {
            steps {
                dir('calculator') {
                    sh "./gradlew jacocoTestReport" 
                }
            }
        }
        stage("Static code analysis") {
            steps {
                dir('calculator') {
                    sh "./gradlew checkstyleMain"
                }
            }
        }
        
    }
}