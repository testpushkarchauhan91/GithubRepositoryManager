pipeline {
   agent any
   tools{
      maven 'Maven'
   }
   stages {
      stage('Checkout code') {
        steps {
            checkout scm
        }
      }
      stage('Build') {
        steps {
            echo 'Building the application...'
            sh 'mvn clean install'
         }     
         post {
             always {
               junit 'comment-service/target/surefire-reports/*.xml'
               junit 'favourite-service/target/surefire-reports/*.xml'
               junit 'profile-service/target/surefire-reports/*.xml'
             }
         }
      }  
      stage('Test') {
         steps {
            echo 'Testing the application...'
            sh 'mvn test'
         }
      }
      stage('Deploy') {
         steps {
            echo 'Deploying the application...'
         }
      }
   }
}
