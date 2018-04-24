package com.geriadam.myintentapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MoveWithDataObject extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObject = (TextView) findViewById(R.id.tv_object_received);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name = "+mPerson.getName()+", Age = "+mPerson.getAge()+", Email = "+mPerson.getEmail()+", City = "+mPerson.getCity();

        tvObject.setText(text);
    }
}
