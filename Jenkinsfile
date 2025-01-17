@Library('piper') _

pipeline {
    agent {
        any {
            image 'astanciuona/my-piper-test-image' // Your custom Docker image
        }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building the piper-test Java project...'
                sh './mvnw clean package' // Adjust this if you use a different build tool
            }
        }
        stage('Load Config') {
            steps {
                script {
                    // Load the config file from resources/config.yml
                    def configContent = libraryResource('config.yml')
                    echo "Loaded config: ${configContent}"
                }
            }
        }
        stage('Run Piper Test Step') {
            steps {
                script {
                    // Call the custom step
                    piperTestStep()
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}
