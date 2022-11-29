package com.example.e_vrtic;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.e_vrtic.model.Child;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LoadPersonsTask extends AsyncTask<String, String, String> {

    private ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {

        JSONArray jsonArray=null;
        try {
            JsonNode loginResult = Unirest.get(MainActivity.URL+MainActivity.PERSONS_PATH).asJson().getBody();
            jsonArray = loginResult.getArray();

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return jsonArray.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(MainActivity2.instance);
        progressDialog.setMessage("Dobavljanje informacija...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    protected void onPostExecute(String jsonText) {

        progressDialog.dismiss();
        try {

            JSONArray jsonArray = new JSONArray(jsonText);
            MainActivity2.list.clear();

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject object = jsonArray.getJSONObject(i);
                Child child = new Child();
                child.setId(object.getString("id"));
                child.setName(object.getString("name"));
                child.setSurname(object.getString("surname"));
                child.setIsHere(object.getBoolean("isHere"));
                child.setFatherName(object.getString("fatherName"));

                MainActivity2.list.add(child);
                MainActivity2.listView.setItemChecked(i, object.getBoolean("isHere"));

            }
            MainActivity2.arrayAdapter.notifyDataSetChanged();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}