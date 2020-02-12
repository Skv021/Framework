def jobName = 'UNKNOWN'
pipeline {
   agent any
   stages{
  
     stage('Source') {
        steps{
                script{
                   node {
              wrap([$class: 'BuildUser']) {
                def user = env.BUILD_USER
                echo "user name is $user"
                 jobName = user + "_" + new Date().format("yyyy_MM_dd_HH_mm_ss", TimeZone.getTimeZone('UTC'))
                currentBuild.displayName = "$jobName"
              }
            }
          }
         // Get some code from our Git repository
         git 'https://github.com/Skv021/Framework.git'
        }
      }
    
      stage('Compile') {
         steps{
        bat 'gradle test classes'
         }
       

}
      stage('Post'){
         steps{
            script {
                bat 'ls extentReports > listFiles.txt'
               def files = readFile("listFiles.txt").split("\\r?\\n");
                sh 'rm -f listFiles.txt'

               
   publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: "extentReports", reportFiles: files[0], reportName: 'index.html', reportTitles: ''])
      }
      }
   }
   }
}
