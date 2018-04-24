package com.geriadam.myfirebasedispatcher;

import android.app.job.JobParameters;
import com.firebase.jobdispatcher.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    public static final String TAG = MyJobService.class.getSimpleName();

    final String APP_ID = "Masukkan API key anda...";

    public static String EXTRAS_CITY = "extras_city";

    @Override
    public boolean onStartJob(com.firebase.jobdispatcher.JobParameters job) {
        return false;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        return false;
    }
}
