pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_6_3' 
        jdk 'JDK_1_8' 
    }
	
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn clean compile'
                }
            }
        }

        }
    }
}
