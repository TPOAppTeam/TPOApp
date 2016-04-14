package com.application.sujata.tpoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.application.sujata.tpoapp.networking.DBUtil;

import java.util.HashMap;

/**
 * Created by sujata on 14/4/16.
 */
public class AcadView extends AppCompatActivity {
    EditText et_ssc,et_hsc,et_entr,et_fy,et_sy,et_ty,et_cpi,et_pass;
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
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_pass.setVisibility(View.GONE);
        setAcadInfoView();

    }
    public void saveStudentInfo(View v){
        Student.setAcadInfo(et_ssc.getText().toString(),et_hsc.getText().toString(),et_entr.getText().toString(),
                et_fy.getText().toString(),et_sy.getText().toString(),et_ty.getText().toString(),et_cpi.getText().toString());
        //Student.setAcadInfo("94","84","122","8.9","9","9","9");
        Student.getStd().setAllInfo();
       // db.saveDataIntoDB(Config.URL_REGISTER,Student.getStd().getAllInfo());

    }
    public void setAcadInfoView() {
        HashMap<String, String> acdInfo = Student.getStd().getAcadInfo();
        et_hsc.setHint(Config.KEY_HSC + ": " + acdInfo.get(Config.KEY_HSC));
        et_ssc.setHint(Config.KEY_SSC + ": " + acdInfo.get(Config.KEY_SSC));
        et_entr.setHint(Config.KEY_ENTR + ": " + acdInfo.get(Config.KEY_ENTR));
        et_fy.setHint(Config.KEY_FY + ": " + acdInfo.get(Config.KEY_FY));
        et_sy.setHint(Config.KEY_SY + ": " + acdInfo.get(Config.KEY_SY));
        et_cpi.setHint(Config.KEY_CPI + ": " + acdInfo.get(Config.KEY_CPI));
        et_ty.setHint(Config.KEY_TY + ": " + acdInfo.get(Config.KEY_TY));
    }
}
