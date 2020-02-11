def jobName = 'UNKNOWN'
pipeline {
   agent any
   stages{
  
     stage('Source') {
        steps{
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
       
          
          script{
       jobName = env.JOB_NAME + "_" + new Date().format("yyyy_MM_dd_HH_mm_ss", TimeZone.getTimeZone('UTC'))
currentBuild.displayName = "$jobName"
          
             echo 'job name is $jobName'
          }
   
      }
      }
   }
}
