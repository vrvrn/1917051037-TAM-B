package com.example.myflexiblefragment1037;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbKl, rbHm, rbKc, rbPd;
    private OnOptionDialogListener odl;
    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOdl() {
        return odl;
    }
    public void setOnOptionDialogListener(OnOptionDialogListener odl) {
        this.odl = odl;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button) view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button) view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = (RadioGroup) view.findViewById(R.id.rg_options);
        rbKl = (RadioButton) view.findViewById(R.id.rb_kl);
        rbHm = (RadioButton) view.findViewById(R.id.rb_hm);
        rbKc = (RadioButton) view.findViewById(R.id.rb_kc);
        rbPd = (RadioButton) view.findViewById(R.id.rb_pd);
        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_kl:
                            coach = rbKl.getText().toString().trim();
                            break;
                        case R.id.rb_hm:
                            coach = rbHm.getText().toString().trim();
                            break;
                        case R.id.rb_kc:
                            coach = rbKc.getText().toString().trim();
                            break;
                        case R.id.rb_pd:
                            coach = rbPd.getText().toString().trim();
                            break;
                    }
                    getOdl().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }
    }
    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }
}