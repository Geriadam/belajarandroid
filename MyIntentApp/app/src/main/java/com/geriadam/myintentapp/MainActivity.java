package com.geriadam.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveWithData;
    private Button btnMoviWithObject;
    private Button btnDialNumber;
    private Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveWithData = (Button)findViewById(R.id.btn_move_activity_data) ;
        btnMoviWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnDialNumber   = (Button)findViewById(R.id.btn_dial_number);
        btnMoveForResult = (Button)findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnMoviWithObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);

        tvResult = (TextView)findViewById(R.id.tv_result);
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
                break;
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("GeriAdamSaputra");
                mPerson.setAge(20);
                mPerson.setEmail("geriadam@gmail.com");
                mPerson.setCity("Surabaya");
                Intent moveWithObject = new Intent(MainActivity.this, MoveWithDataObject.class);
                moveWithObject.putExtra(MoveWithDataObject.EXTRA_PERSON, mPerson);
                startActivity(moveWithObject);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}
