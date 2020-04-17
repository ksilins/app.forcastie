pipeline {
  agent any

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
        git 'https://github.com/ksilins/app.forcastie.git'
        sh 'gradle build'
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
