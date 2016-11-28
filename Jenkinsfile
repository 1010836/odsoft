#!groovy
node {
    stage('Checkout') {
        // Only checkout the code from the repository
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ecb1ee13-2552-4a2e-bd64-85b1ded80b38', url: 'https://1010836@bitbucket.org/mei-isep/odsoft-2016-nmb-g101.git']]])
   }
   
   stage('Build Jar') {
        // Only obtain the jar ofbiz (ofbiz.jar)
        dir('ofbiz') {
            if (isUnix()) {
                sh './gradlew jar'
            } else {
                bat "./gradlew jar"
            }
        }
   }
   
    stage('Archive Jar') {
        //Archive the (ofbiz.jar) from the previous stage
        dir('ofbiz') {
            archiveArtifacts 'build/libs/ofbiz.jar'
        }
    }
    
    stage('Unit Tests') {
        dir('ofbiz') {
            // Run unit tests
            if (isUnix()) {
                sh returnStatus: true, script: './gradlew test'
            } else {
                ignoreFailures = true
                bat "./gradlew test"
            }
            //Publish the results of unit tests
            publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests', reportFiles: 'index.html', reportName: 'Tests'])
        }
    }
    
  stage('Jacoco Unit Tests') {
        dir('ofbiz') {
            // Create Jacoco coverage report
            if (isUnix()) {
                sh './gradlew jacocoTestReport'
            } else {
                bat "./gradlew jacocoTestReport"
            }
            //Publish the results of unit tests
            publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/jacocoHtml', reportFiles: 'index.html', reportName: 'Jacoco'])
        }
	}

   
   stage('Integration Tests') {

      dir('/var/lib/jenkins/workspace/ODSOFT_Exercise6/ofbiz') {

        // Run integration tests
        sh returnStatus: true, script: './gradlew ofbizIntegrationTest'        
        
      }


   }
   
   stage('Jacoco Integration Tests') {

      dir('/var/lib/jenkins/workspace/ODSOFT_Exercise6/ofbiz') {

        // Run integration tests
        sh returnStatus: true, script: './gradlew ofbizCodeCoverageReport'

        //Publish the results of unit tests
        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '/build/reports/jacoco/ofbizCodeCoverageReport/html/', reportFiles: 'index.html', reportName: 'IntegrationTestsCoverage'])

      }


   }

}
