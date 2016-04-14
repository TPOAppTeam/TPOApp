package com.application.sujata.tpoapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by sujata on 13/4/16.
 */
public class Config {

    public static final String URL_REGISTER="https://tpo-app-priyankarthorat-2.c9users.io/application/RegisterStudent.php";
    public static final String URL_LOGIN="https://tpo-app-priyankarthorat-2.c9users.io/application/StudentLogin.php";
    //Keys that will be used to send the request to php scripts : table Student
    public static final String KEY_PRN = "PRN";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DOB = "DOB";
    public static final String KEY_Email = "Email";
    public static final String KEY_Contact = "Contact";
    public static final String KEY_Branch = "Branch";
    public static final String KEY_Pass = "Password";

    public static final String KEY_SSC = "SSC";
    public static final String KEY_HSC = "HSC";
    public static final String KEY_FY = "FY";
    public static final String KEY_SY = "SY";
    public static final String KEY_ENTR = "Entrance";
    public static final String KEY_TY = "TY";
    public static final String KEY_CPI = "CPI";



    //JSON Tagsd
    public static final String TAG_JSON_ARRAY="result";

    public static void redirectToAcademia(Activity activity){
        Intent t =  new Intent(activity,Academia.class);
        activity.startActivity(t);
        activity.finish();
    }
    public static void redirectToPerProfile(Activity activity){
        Intent t =  new Intent(activity,SignUp.class);
        activity.startActivity(t);
        activity.finish();
    }
    public static void redirectToStudentMenu(Activity activity){
        Intent t =  new Intent(activity,StudentMenu.class);
        activity.startActivity(t);
        activity.finish();
    }


}
