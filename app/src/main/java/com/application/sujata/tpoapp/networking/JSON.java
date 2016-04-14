package com.application.sujata.tpoapp.networking;


import com.application.sujata.tpoapp.Config;
import com.application.sujata.tpoapp.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sujata on 24/3/16.
 */
public class JSON {

    private JSONArray list = null;
    private String json;
    public JSON(String json){
        this.json = json;
    }


    protected List<String> parseJSON(String attr) {
        List<String> categories = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            list = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i=0;i< list.length();i++){


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return categories;
    }

    protected void setProfile(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            list = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i=0;i< list.length();i++){

                JSONObject jo = list.getJSONObject(i);
                //String PRN, String name, String contact, String email, String branch, String DOB
                Student.setPersonalInfo(jo.getString(Config.KEY_PRN),jo.getString(Config.KEY_NAME),
                        jo.getString(Config.KEY_Contact),jo.getString(Config.KEY_Email),jo.getString(Config.KEY_Branch),
                        jo.getString(Config.KEY_DOB));

                //String SSC, String HSC, String entr, String FY, String SY, String TY, String CPI
                Student.setAcadInfo(jo.getString(Config.KEY_SSC),jo.getString(Config.KEY_HSC),jo.getString(Config.KEY_ENTR),
                        jo.getString(Config.KEY_FY),jo.getString(Config.KEY_SY),jo.getString(Config.KEY_TY),
                        jo.getString(Config.KEY_CPI));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
