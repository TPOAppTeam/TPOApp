package com.application.sujata.tpoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.application.sujata.tpoapp.networking.DBUtil;

import java.util.HashMap;

public class SignInUp extends AppCompatActivity {

    EditText et_un;
    EditText et_pass;
    DBUtil db;

    public static String getPRN() {
        return PRN;
    }

    public static void setPRN(String PRN) {
        SignInUp.PRN = PRN;
    }

    private static String PRN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);
        initilize();
    }

    public void initilize(){

        db = new DBUtil(this);
        et_un = (EditText) findViewById(R.id.editTextUN);
        et_pass= (EditText) findViewById(R.id.et_pass);
    }

    public void signUp(View v){

        Config.redirectToPerProfile(this);
    }
    public void signInStudent(View v){


        PRN = et_un.getText().toString();
        String pass = et_pass.getText().toString();

        HashMap<String,String> data = new HashMap<>();
        data.put(Config.KEY_PRN,PRN);
        data.put(Config.KEY_Pass,pass);

        db.retrieveDetails(Config.URL_LOGIN,data);

    }
    public void authenticate(String resp){
        if(!resp.contains("invalid")){
            Config.redirectToStudentMenu(this);
        }
    }
}
