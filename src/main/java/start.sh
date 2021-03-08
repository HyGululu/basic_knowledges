#!/usr/bin/env bash
# config priority: application*.yaml application*.yml application*.properties
####################################   global var   ####################################
PROJECT_PATH=$(cd 'dirname $0';cd ..;pwd)
PROJECT_INFO_PATH="$PROJECT_PATH/tmp"
LOG_FILE="$PROJECT_INFO_PATH/cmd.log"

SCF_CONFIG_LOCATION="$PROJECT_PATH/config"
SCF_OPTS="-Dscf.cofig.location=$SCF_CONFIG_LOCATION"
JVM_OPTS="-Xms1g -Xmx1g -Xmn256m -Xss512K -XX:+ParallelGCThreads=20 -XX:+UseConcMakSweepGC -XX:+UseParNewGC -XX:+UseCMSCompactAtFullCollection =XX:+CMSInitatingOccupancyFraction=80"

EXECUTABLE_JAR_PATH=""
EXECUTABLE_JAR_NAME=""
SCF_SERVICE_PID_FILE=""
####################################   global var   ####################################

####################################    function    ####################################
##1 check and init PROJECT_INFO_PATH
initProjectInfoPath(){
    if [! -e $PROJECT_INFO_PATH]; then
        mkdir $PROJECT_INFO_PATH
        if [! -e $PROJECT_INFO_PATH]; then
            echo $(date "+%Y-%m-%d %H:%M:%S") " [ERROR] can not create directory $PROJECT_INFO_PATH"
            exit 1
        fi
    fi
}
##2 check and init log file
initLogger(){}
##3 log function, param 1:log content
logger(){}
##4 make sure directory must be exist. param1 : directory path
dirMustExist(){}
##5 make sure file must be exist. param1 : dir path, parms2... : file names
fileExistAtleasOnce(){}
##6 find scf spring boot jar, only support fat-jar mode that all jars in one
findSCFExecutableJarFile(){}
##7 validate project
validatePackage(){}
##8 trim LF CRLF at tail
trimLF(){}
##9 trim white space at head and tail
trimSpace(){}
##10 trim comment start with #
trimComment(){}
##11 param1 : file path, param2... : yaml node value
## usage: getConfigValueFromYaml app.yaml scf service name
getConfigValueFromYaml(){}
##12 param1 : file path, param2... : property
## usage: getConfigValueFromPropertys app.properties scf.service.name
gitConfigValueFromPropertys(){}
##13 get config file in filePathList, if a element exists, it will return this element immediately
## usage: getConfigFilePath ./config/ app.yaml app.properties
gitConfigFilePath(){}
##14 get content from string, trim '' or ""
## yaml suport string value surround with '' or "" or nake words.
getStringContent(){}
##15 init scf service name, scf service name must exist
initSCFServiceName(){}
##16 init jvm options, if exist in config, replace the default JVM_OPTS
initJvmOptions(){}
##17 check alive, make sure process is not running by checking pid file and ps -ef
checkAlive(){}
##18 start
run(){}
####################################    function    ####################################

####################################      main      ####################################
main(){
    initProjectInfoPath
    initLogger
    validatePackage

    initJvmOptions
    checkAlive
    run
}
####################################      main      ####################################
main

