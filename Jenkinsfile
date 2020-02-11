pipeline {
   agent any

   stage('Build') {
	   steps {
		
		  git 'https://github.com/Skv021/Framework.git'
	   }
	   
   stages {
      stage('Hello') {
         steps {
            echo 'Hello World'
         }
      }
	  
	 stage('Compile') {
        gradle {
            tasks: 'clean'
            tasks: 'test'
        }
   }
}
}
}