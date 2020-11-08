def checkout = { String subFolder ->
    checkout([
            $class      : "GitSCM",
            branches    : [[name: "*/master"]],
            extensions  : [[ $class: "RelativeTargetDirectory",
                             relativeTargetDir: subFolder
                           ]],
            userRemoteConfigs: [[
                                        url : 'git@github.com:josewolff/UFM-TestAutomation-2020.git',
                                        credentialsId: "wolff-repo"
                                ]]
    ])
}

def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }

parallel Chrome: {
    stage("Chrome"){
        node('myNode'){
            checkout("chrome")
            runner 'cd chrome && mvn test -Dbrowser=chrome -DincludeGroup=${includeGroup} -DseleniumHost=${seleniumHost}'
        }
    }
},
Firefox: {
    stage("Firefox"){
        node('myNode'){
            checkout("chrome")
            runner 'cd chrome && mvn test -Dbrowser=firefox -DincludeGroup=${includeGroup} -DseleniumHost=${seleniumHost}'
        }
    }
},
Safari: {
    stage("Safari"){
        node('myNode'){
            checkout("chrome")
            runner 'cd chrome && mvn test -Dbrowser=safari -DincludeGroup=${includeGroup} -DseleniumHost=${seleniumHost}'
        }
    }
}


