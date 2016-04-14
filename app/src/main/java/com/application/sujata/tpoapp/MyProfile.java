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
public class MyProfile extends AppCompatActivity {

    EditText et_prn,et_name,et_contact,et_branch,et_dob,et_email;

    DBUtil db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initilize();
    }

    public void initilize(){

        db = new DBUtil(this);
        et_prn = (EditText) findViewById(R.id.prn);
        et_name = (EditText) findViewById(R.id.name);
        et_contact = (EditText) findViewById(R.id.contact);
        et_branch = (EditText) findViewById(R.id.branch);
        et_dob = (EditText) findViewById(R.id.birth);
        et_email = (EditText) findViewById(R.id.email);

        db.getDetails(Config.URL_MYPROFILE, SignInUp.getPRN());
    }
    public void showAcademia(View v){


        Config.redirectToAcademia(this);

    }

    public void setPersonalInfoView(){
        HashMap<String,String> perInfo = Student.getStd().getPersonolInfo();
        et_prn.setHint(Config.KEY_PRN+":"+perInfo.get(Config.KEY_PRN));
        et_name.setHint(Config.KEY_NAME+":"+perInfo.get(Config.KEY_NAME));
        et_contact.setHint(Config.KEY_Contact+":"+perInfo.get(Config.KEY_Contact));
        et_branch.setHint(Config.KEY_Branch+":"+perInfo.get(Config.KEY_Branch));
        et_dob.setHint(Config.KEY_DOB+":"+perInfo.get(Config.KEY_DOB));
        et_email.setHint(Config.KEY_Email + ":" + perInfo.get(Config.KEY_Email));
    }


}
