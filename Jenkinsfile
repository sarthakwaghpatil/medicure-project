node{
    def mavenHome
    def mavenCMD
    def docker
    def dockerCMD
    def tagName
    stage('prepare environment'){
        echo "initialize all variable"
        mavenHome = tool name: 'maven' , type: 'maven'
        mavenCMD = "${mavenHome}/bin/mvn"
        docker = tool name: 'docker' , type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        dockerCMD = "${docker}/bin/docker"
        tagName = "1.0"

    }
    stage('code checkout'){
        git 'https://github.com/sarthakwaghpatil/medicure-project.git'
    }
    stage('compile and package'){
        echo "cleaning compiling testing and packaging"
        //sh 'mvn clean package'
        sh "${mavenCMD} clean package"
    }
    stage('publish html reports'){
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'sarthakwaghpatil@gmail.com', reportFiles: '/var/lib/jenkins/workspace/healthcare-domain/target/surefire-reports', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
    }
    stage('build an image'){
        echo "containerizing the application"
        sh "${dockerCMD} build -t sarthakwaghpatil/medicure:${tagName} ."
    }
    stage('pushing image to dockerhub'){
        echo "pushing the image to dockerhub"
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerhubpassword')]) {
        sh "${dockerCMD} login -u sarthakwaghpatil -p ${dockerhubpassword}"
        sh "${dockerCMD} push sarthakwaghpatil/medicure:${tagName}"    
        }
    }
    stage('configure and deploy to test server'){
        ansiblePlaybook become: true, credentialsId: 'ansible-key', disableHostKeyChecking: true, installation: 'ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook.yml'
    }
}
