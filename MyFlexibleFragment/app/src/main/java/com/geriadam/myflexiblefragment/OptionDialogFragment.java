package com.geriadam.myflexiblefragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose,btnClose;
    private RadioButton rbBakso, rbNasiGoreng, rbPecel, rbMiAyam;
    private RadioGroup rgOption;
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment(){

    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener){
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view       = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose       = (Button)view.findViewById(R.id.btn_choose);
        btnClose        = (Button)view.findViewById(R.id.btn_close);
        rgOption        = (RadioGroup)view.findViewById(R.id.rg_options);
        rbBakso         = (RadioButton)view.findViewById(R.id.rb_bakso);
        rbNasiGoreng    = (RadioButton)view.findViewById(R.id.rb_nasigoreng);
        rbMiAyam        = (RadioButton)view.findViewById(R.id.rb_miayam);
        rbPecel         = (RadioButton)view.findViewById(R.id.rb_pecel);
        btnChoose.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int chekedRadioButtonId = rgOption.getCheckedRadioButtonId();
                    String makanan = null;
                    switch (chekedRadioButtonId){
                        case R.id.rb_bakso:
                            makanan = rbBakso.getText().toString().trim();
                            break;
                        case R.id.rb_miayam:
                            makanan = rbMiAyam.getText().toString().trim();
                            break;
                        case R.id.rb_nasigoreng:
                            makanan = rbNasiGoreng.getText().toString().trim();
                            break;
                        case R.id.rb_pecel:
                            makanan = rbPecel.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionChoosen(makanan);
                    getDialog().cancel();
        }
    }

    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }
}
