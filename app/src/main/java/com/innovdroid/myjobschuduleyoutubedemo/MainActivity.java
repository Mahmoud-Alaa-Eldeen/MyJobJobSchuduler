// you may to check if api <21 use a service code like Asynctask
// but if >=21 user jobService
package com.innovdroid.myjobschuduleyoutubedemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    // each job has Id
    int jobId = 0;

    public void startJob(View view) {

        JobInfo.Builder builder = new JobInfo.Builder(jobId++, new ComponentName(this, MyJobService.class));
        builder.setMinimumLatency(1000); //run after 1000 milliseconds
        builder.setOverrideDeadline(2000);// run for 2000 milliseconds

        // other job features
        // to repeat this job every 2000 millisecinds
       // builder.setPeriodic(2000);
        //to run after device boot (need permission)
       // builder.setPersisted(true);
        // specify network type to run this job(need access network state permission)
      //  builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);

        // run this job service only if the device on charging
       // builder.setRequiresCharging(true);
        //not to stop the app a bit while using, make the service run during not using of app.
       // builder.setRequiresDeviceIdle(true);

        // register my job to JobScheduler (send to system)
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());


    }
}
