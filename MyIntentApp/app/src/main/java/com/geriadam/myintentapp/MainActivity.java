package com.geriadam.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveWithData;
    private Button btnDialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveWithData = (Button)findViewById(R.id.btn_move_activity_data) ;
        btnDialNumber   = (Button)findViewById(R.id.btn_dial_number);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithData = new Intent (MainActivity.this, MoveWithDataActivity.class);
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Geri adam saputra");
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 17);
                startActivity(moveWithData);
                break;
            case R.id.btn_dial_number:
                String number = "085745747195";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(dialPhone);

        }
    }
}
