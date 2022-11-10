package com.example.e_vrtic;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UpdatePersonsTask extends AsyncTask<String, String, String> {

    private ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {

        String searchQueryApi = MainActivity.URL;
        JsonNode body = null;
        try {
            body = Unirest.get(searchQueryApi).asJson().getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return body.toString();
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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                MainActivity2.list.add(obj.getInt("id") + " " + obj.getString("name"));
                MainActivity2.arrayAdapter.notifyDataSetChanged();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}