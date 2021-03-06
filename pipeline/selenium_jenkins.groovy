import hudson.model.*;
 
pipeline{
 
    agent any
    parameters {
        string(name: 'BROWSER_TYPE', defaultValue: 'chrome', description: 'Type a browser type, should be chrome/firefox')
        string(name: 'TEST_SERVER_URL', defaultValue: '', description: 'Type the test server url')
        string(name: 'NODE', defaultValue: 'selenium-jenkins-demo', description: 'Please choose a windows node to execute this job.')
    }
    
	stages{
	    stage("Initialization"){
	        steps{
	            script{
	                browser = BROWSER_TYPE?.trim()
	                test_url = TEST_SERVER_URL?.trim()
	                win_node = NODE?.trim()
	            }
	        }
	    }
	    stage("Git Checkout"){
	        //steps{
	          //  script{
 	         //             checkout([$class: 'GitSCM', branches: [[name: '*/master']],
			//			    userRemoteConfigs: [[credentialsId: '6f4fa66c-eb02-46dc-a4b3-3a232be5ef6e', 
			//				url: 'https://github.com/QAAutomationLearn/JavaAutomationFramework.git']]])
	         //   }
	        //}
	    }
	    
        
	    //stage("Run Selenium Test"){
	    //    steps{
	     //       script{
 	     ////               run_bat = env.WORKSPACE + "\\run.bat"
	     //               bat (run_bat)
	     //       }
	     //   }
	   // }
	}
}