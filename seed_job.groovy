job('test_job_1') {
  displayName('Test Job 1')
  description('A job for testing.')
  label('all_jobs')
  scm {
    github('swegner/jenkins_playground', 'master')
  }
  publishers {
    git {
      branch('https://github.com/swegner/jenkins_playground.git', 'job_output')
      pushOnlyIfSuccess
    }
  }
}
