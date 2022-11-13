package com.example.e_vrtic;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UpdatePersonsTask extends AsyncTask<String, String, String> {

    private ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {

        String searchQueryApi = MainActivity.URL+MainActivity.PERSONS_PATH;
        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<MainActivity2.list.size(); i++){

            if(MainActivity2.listView.isItemChecked(i)){
                MainActivity2.list.get(i).setIsHere(true);
            }else{
                MainActivity2.list.get(i).setIsHere(false);
            }

            JSONObject object = new JSONObject();
            try {
                object.put("id", MainActivity2.list.get(i).getId());
                object.put("name", MainActivity2.list.get(i).getName());
                object.put("parentName", MainActivity2.list.get(i).getParentName());
                object.put("surname", MainActivity2.list.get(i).getSurname());
                object.put("isHere", MainActivity2.list.get(i).getIsHere());
                jsonArray.put(object);
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        Integer statusCode = 0;

        try {
            statusCode = Unirest.put(searchQueryApi).body(jsonArray.toString().getBytes())
                    .asBinary().getStatus();

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return statusCode.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(MainActivity2.instance);
        progressDialog.setMessage("Ažuriranje podataka...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }



    @Override
    protected void onPostExecute(String ststusCode) {

        progressDialog.dismiss();
        Toast.makeText(MainActivity2.instance, ststusCode, Toast.LENGTH_SHORT).show();
        if(!ststusCode.equals("200")){
            Toast.makeText(MainActivity2.instance, "Neuspješno ažuriranje podataka", Toast.LENGTH_LONG).show();
        }

    }

}