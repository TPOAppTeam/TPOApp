package com.application.sujata.tpoapp.networking;


import com.application.sujata.tpoapp.Config;

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

}
