pipeline {
   agent any	   
   stages {
      stage('Hello') {
         steps {
            echo 'Hello World'
         }
      }
	  stage('Build') {
	   steps {
		
		  git 'https://github.com/Skv021/Framework.git'
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