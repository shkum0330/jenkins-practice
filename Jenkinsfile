pipeline {
    agent any

    // triggers {
    //     pollSCM('* * * * *')
    // }

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
                    sh "docker build --platform linux/amd64 -t shkum0330/calculator ."
                }
            }
        }
        stage("Docker login") {
            steps {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub-credentials',
                        usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                    sh "docker login --username $USERNAME --password $PASSWORD"
                }
            }
        }   
        stage("Docker push") {
            steps {
                sh "docker push shkum0330/calculator"
            }
        }          
        stage("Deploy to staging"){
             steps {
                dir('calculator') {
                    sh "docker run -d --rm -p 8765:8080 --name calculator shkum0330/calculator ."
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