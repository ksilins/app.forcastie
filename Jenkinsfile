pipeline {
   agent any

   environment {
           APPIUM_PORT= 5555
       }

   tools {
      gradle "Gradle"
   }

   stages {
      stage('Build apk') {
         steps {
            git 'https://github.com/martykan/forecastie.git'
            sh './gradlew clean clean assembleDebug'
            sh 'mv app/build/outputs/apk/debug/app-debug.apk ~/'
         }
      }

      stage('Run test') {
          steps {
              echo "Start appium server"
              sh "appium --port ${4723}"
              git 'https://github.com/ksilins/app.forcastie.git'
              sh 'gradle build'
          }
          post{
                  always{
                      echo "Stop appium server"
                      sh "kill \$(lsof -t -i :${4723})"
                  }
      }
   }

    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}
