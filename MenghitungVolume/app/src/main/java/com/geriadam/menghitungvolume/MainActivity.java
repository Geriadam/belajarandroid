package com.geriadam.menghitungvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth,edtLenght,edtHeight;
    private Button btnCalulate;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL,tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = (EditText)findViewById(R.id.edt_width);
        edtLenght = (EditText)findViewById(R.id.edt_length);
        edtHeight = (EditText)findViewById(R.id.edt_height);
        btnCalulate = (Button)findViewById(R.id.Calculate);
        tvResult = (TextView)findViewById(R.id.tv_result);
        btnCalulate.setOnClickListener(this);


        if(savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    public void onClick(View v){
        if ( v.getId() == R.id.Calculate ){
            String lenght = edtLenght.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();

            boolean isEmpty = false;
            if(TextUtils.isEmpty(lenght)){
                isEmpty = true;
                edtLenght.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(width)){
                isEmpty = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(height)){
                isEmpty = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if(!isEmpty){
                double l = Double.parseDouble(lenght);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
