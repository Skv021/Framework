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
             
               def cmd = "dir /a:d /b extentReports"
             def x = bat(returnStdout: true,script: "${cmd}")
            x=.tokenize( 'extentReports' )[1]
echo "x=====$x"
   publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: "extentReports//$x", reportFiles:"TestReport.html"  , reportName: 'MyReports', reportTitles: ''])
      }
      }
   }
   }
}
