pipeline 
{

  agent any

  stages
  {

    stage('Checkout') 
    {
      steps
      {
        // Only checkout the code from the repository
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[credentialsId: 'bitbucket-credentials', url: 'https://bitbucket.org/mei-isep/odsoft-2016-nmb-g101.git']]])
      }
    }  

    stage('Build Jar') 
    {
      steps
      {
        // Only obtain the jar ofbiz (ofbiz.jar)
        dir('ofbiz') 
        {
          sh './gradlew jar'
        }
      }
    }

    stage('Archive Jar') 
    {
      steps
      {
        //Archive the (ofbiz.jar) from the previous stage
        dir('ofbiz') 
        {
          archiveArtifacts 'build/libs/ofbiz.jar'
        }
      }
    }

  }

}

