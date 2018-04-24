package com.geriadam.myfirebasedispatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScheduler, btnCancelScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScheduler = (Button)findViewById(R.id.btn_set_scheduler);
        btnCancelScheduler =(Button)findViewById(R.id.btn_cancel_scheduler);

        btnScheduler.setOnClickListener(this);
        btnCancelScheduler.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v.getId() == R.id.btn_set_scheduler){
            Toast.makeText(this, "Dispatcher create", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.btn_cancel_scheduler){
            Toast.makeText(this, "Dispatcher cancel", Toast.LENGTH_SHORT).show();
        }
    }
}
