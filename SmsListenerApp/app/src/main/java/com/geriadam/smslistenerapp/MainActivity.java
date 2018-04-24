package com.geriadam.smslistenerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDownload;
    public static final String DOWNLOAD_STATUS = "download_status";
    private BroadcastReceiver downloadReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Incoming Message");
        btnDownload = (Button)findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
        downloadReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Download Selesai", Toast.LENGTH_SHORT).show();
            }
        };
        IntentFilter downloadFilter = new IntentFilter(DOWNLOAD_STATUS);
        registerReceiver(downloadReceiver, downloadFilter);
    }

    public void onClick(View v){
        if(v.getId() == R.id.btn_download){
            Intent downloadServiceIntent = new Intent(MainActivity.this, DownloadService.class);
            startService(downloadServiceIntent);
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        if (downloadReceiver != null){
            unregisterReceiver(downloadReceiver);
        }
    }
}
