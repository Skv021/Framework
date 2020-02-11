pipeline {
   agent any
   stages{
  
     stage('Source') {
        steps{
         // Get some code from our Git repository
         git 'https://github.com/Skv021/Framework.git'
        }
      }
     withGradle {
      stage('Compile') {
         steps{
        gradle {
            tasks: 'clean'
            tasks: 'test'
        }
         }
       
}
}
   
}
