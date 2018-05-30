job('test_job_1') {
  displayName('Test Job 1')
  description('A job for testing.')
  // label('all_jobs')
  scm {
    github('swegner/jenkins_playground', 'master')
  }
  triggers {
    // githubPush()
    // scm('* * * * *')
    ghprbTrigger {
      cron('* * * * *')
      includedRegions('test_job_1/.*')
    }
  }
  steps {
    groovyCommand 'println "hello from groovy"'
    shell readFileFromWorkspace('test_job_1/jenkins.sh')
  }
  /*
  publishers {
    git {
      branch('origin', 'job_output')
      pushOnlyIfSuccess
    }
  }
  */
}
