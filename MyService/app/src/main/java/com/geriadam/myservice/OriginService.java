package com.geriadam.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class OriginService extends Service {
    public static final String ORIGIN_SERVICE = "origin_service";
    public OriginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(ORIGIN_SERVICE, "OriginService di jalankan");
        return START_STICKY;
    }

    public class ProsesAsync extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... params){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPreExecute();
            Log.d(ORIGIN_SERVICE, "StopService");
            stopSelf();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(ORIGIN_SERVICE, "DestroyService");
    }
}
