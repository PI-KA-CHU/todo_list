pipeline {
    agent any
    
    environment {
        CI = 'true'
    }
    
    stages { 

        stage('Build') {
            steps {
                echo 'build'
                bat 'gradle build'
            }
        }
        
        stage ('OWASP Dependency-Check Vulnerabilities') {
            steps {
                dependencyCheck additionalArguments: ''' 
                    -o "./" 
                    -s "./"
                    -f "ALL" 
                    --prettyPrint''', odcInstallation: 'OWASP-DC'

                dependencyCheckPublisher pattern: 'dependency-check-report.xml'
            }
        } 
    }
}
