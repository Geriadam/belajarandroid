package com.geriadam.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DicodingIntentService extends IntentService {

    public static String EXTRA_DURATION = "extra_dration";
    public static final String TAG = "DicodingIntentService";


    public DicodingIntentService(){
        super("DicodingIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent){
        Log.d(TAG,"onHandleIntent()");
        if (intent != null){
            int duration = intent.getIntExtra(EXTRA_DURATION, 0);
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }
}
