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


        stage("Docker build") {
            steps {
                dir('calculator') {
                    sh "docker build --platform linux/amd64 -t shkum0330/calculator ."
                }
            }
        }
        stage("Docker login") {
            steps {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
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
                sh "docker run -d --rm -p 8765:8765 --name calculator shkum0330/calculator ."
            }
        }

        stage("Acceptance test") { 
            steps { 
                sleep 60 
                sh "./gradlew acceptanceTest -Dcalculator.url=http://localhost:8765"
            } 
        }

     
    }
    post {
        always {
            sh "docker stop calculator"
        }
    }   
}