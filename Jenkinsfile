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
        try{
            git 'https://github.com/sarthakwaghpatil/medicure-project.git'
        }
        catch (Exception e){
            echo "exception occured in git code checkout"
            currentBuild.result ="FAILURE"
            emailext body: '''dear all,
            the jenkins job has been failed . request you to please have a look at it immediately by clicking on below link
            ${BUILD_URL}''', recipientProviders: [buildUser()], subject: 'jenkins job ${JOB_NAME} ${JOB_NUMBER} is failed', to: 'sarthakwaghpatil@gmail.com'
        }
    }
    stage('compile and package'){
        echo "cleaning compiling testing and packaging"
        //sh 'mvn clean package'
        sh "${mavenCMD} clean package"
    }
    stage('publish html reports'){
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'sarthakwaghpatil@gmail.com', reportFiles: '/var/lib/jenkins/workspace/medicure/target/surefire-reports', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
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
