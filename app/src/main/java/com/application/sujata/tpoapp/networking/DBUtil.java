package com.application.sujata.tpoapp.networking;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.application.sujata.tpoapp.SignInUp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sujata on 22/3/16.
 */
public class DBUtil {



    Activity activity;

    public DBUtil(Activity activity){
        this.activity = activity;
    }

    public void saveDataIntoDB(final String url,final HashMap<String,String> data){
        class Save extends  AsyncTask<Void,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(activity, "Saving...", "Wait...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(activity, s, Toast.LENGTH_LONG).show();

            }
            @Override
            protected String doInBackground(Void... v) {

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(url, data);
                return res;
            }
        }

        Save s = new Save();
        s.execute();
    }

    public void retrieveDetails(final String url,final HashMap<String,String> data){
        class Retrieve extends  AsyncTask<Void,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(activity, "Saving...", "Wait...", false, false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(activity, s, Toast.LENGTH_LONG).show();
                if(activity instanceof SignInUp){
                    ((SignInUp) activity).authenticate(s);
                }
            }
            @Override
            protected String doInBackground(Void... v) {

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(url, data);
                return res;
            }
        }

        Retrieve s = new Retrieve();
        s.execute();
    }

}
