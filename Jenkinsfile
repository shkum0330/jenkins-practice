pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/shkum0330/jenkins-practice', branch: 'main'
            }
        }
        
    
        stage('Compile'){
            steps{
                dir('calculator') {
                    sh "./gradlew compileJava"  
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