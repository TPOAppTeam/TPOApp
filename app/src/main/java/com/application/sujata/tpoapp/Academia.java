package com.application.sujata.tpoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.application.sujata.tpoapp.networking.DBUtil;

import java.util.HashMap;

public class Academia extends AppCompatActivity {

    EditText et_ssc,et_hsc,et_entr,et_fy,et_sy,et_ty,et_cpi;
    DBUtil db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academia);
        initlize();

    }
    public void initlize(){

        db = new DBUtil(this);
        et_ssc = (EditText) findViewById(R.id.SSC);
        et_hsc = (EditText) findViewById(R.id.HSC);
        et_entr = (EditText) findViewById(R.id.Entrance);
        et_fy = (EditText) findViewById(R.id.FY);
        et_sy = (EditText) findViewById(R.id.SY);
        et_ty = (EditText) findViewById(R.id.Ty);
        et_cpi = (EditText) findViewById(R.id.Cpi);
    }
    public void saveStudentInfo(View v){
        Student.setAcadInfo(et_ssc.getText().toString(),et_hsc.getText().toString(),et_entr.getText().toString(),
                et_fy.getText().toString(),et_sy.getText().toString(),et_ty.getText().toString(),et_cpi.getText().toString());
        //Student.setAcadInfo("94","84","122","8.9","9","9","9");
        Student.getStd().setAllInfo();
        db.saveDataIntoDB(Config.URL_REGISTER,Student.getStd().getAllInfo());

    }

}
