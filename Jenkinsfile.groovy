@Library('piper') _

pipeline {
    agent {
        docker {
            image 'astanciuona/my-piper-test-image' // Your custom Docker image
        }
    }
    environment {
        PATH = "${env.PATH}:/home/piper/bin" // Ensure Piper binaries are in the PATH
    }
    stages {
        stage('Setup') {
            steps {
                echo 'Setting up the environment...'
                script {
                    // Initialize Piper, if required
                    piperExecuteBin script: this
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Building the piper-test Java project...'
                sh './mvnw clean package' // Adjust this if you use a different build tool
            }
        }
        stage('Custom Step') {
            steps {
                echo 'Executing custom Java step...'
                script {
                    // Run your custom Java logic from the packaged .jar
                    sh 'java -cp target/piper-test-0.0.1-SNAPSHOT.jar com.onapis.piper_test.PiperTestApplication'
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
