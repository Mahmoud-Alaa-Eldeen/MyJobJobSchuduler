package com.innovdroid.myjobschuduleyoutubedemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import static android.R.attr.tag;

/**
 * Created by mahmoud on 04/09/17.
 */

public class MyJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        //call url for ex.
        Log.i("tag:" + "job", "msg:" + "job is started successfully!");

        // finish the job. using its id
        // second param. is needResechudle: false (no need for start again)
        // or can depend on a bool value indicate to start again or not.for ex:
        // boolean downloaded=downloadFile();
        jobFinished(jobParameters, false);


        // return false if there is no thing else to do
        // but return truw will take the main thread, when you download from
        // http for ex. or along background process.if said false will be killed
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("tag:" + "job", "msg:" + "job is stopped successfully!");

        return false;
    }
}
