node{
    stage('checkout the code'){
        git 'https://github.com/sarthakwaghpatil/finance-project.git'
    }
    stage('terraform init'){
        sh 'sudo terraform init'
    }
    stage('terraform validate'){
        sh 'terraform validate'
    }
    stage('terraform plan'){
       withCredentials([string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID')]) {

           withCredentials([string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')]) {
    
                sh 'terraform plan'
            }
        }
    }
    stage('terraform apply'){
        sh 'terraform apply --auto-approve'
    }
}
