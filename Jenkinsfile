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
        stage('Initialize') {
            steps {
                script {
                    // Load configuration from the shared library's .pipeline/config.yml
                    def configContent = libraryResource('.pipeline/config.yml')
                    def config = readYaml text: configContent
                    echo "Loaded config: ${config}"
                }
            }
        }
        stage('Run Piper Test Step') {
            steps {
                script {
                    // Call the custom step from the shared library
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
