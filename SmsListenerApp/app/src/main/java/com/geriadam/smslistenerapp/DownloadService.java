package com.geriadam.smslistenerapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DownloadService extends IntentService {
   public static final String TAG = "DownloadService";

   public DownloadService(){
       super("DownloadService");
   }

   protected void onHandleIntent(Intent intent){
       Log.d(TAG, "Download service di jalankan");
       if (intent != null){
           try {
               Thread.sleep(5000);
           } catch (Exception e){
               e.printStackTrace();
           }
           Intent notifyFinishIntent = new Intent(MainActivity.DOWNLOAD_STATUS);
           sendBroadcast(notifyFinishIntent);
       }
   }

}
