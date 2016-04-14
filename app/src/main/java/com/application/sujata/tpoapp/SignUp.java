package com.application.sujata.tpoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText et_prn,et_name,et_contact,et_branch,et_dob,et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initilize();
    }

    public void initilize(){
        et_prn = (EditText) findViewById(R.id.prn);
        et_name = (EditText) findViewById(R.id.name);
        et_contact = (EditText) findViewById(R.id.contact);
        et_branch = (EditText) findViewById(R.id.branch);
        et_dob = (EditText) findViewById(R.id.birth);
        et_email = (EditText) findViewById(R.id.email);

    }
    public void showAcademia(View v){

        Student.setPersonalInfo(et_prn.getText().toString(),et_name.getText().toString(),et_contact.getText().toString(),
                        et_email.getText().toString(),et_branch.getText().toString(),et_dob.getText().toString());
        //Student.setPersonalInfo("2013BIT039","Sujata Regoti","8598405",
          //      "sujata@gmail.com","CSE","1995-11-10");
        Config.redirectToAcademia(this);

    }



}
