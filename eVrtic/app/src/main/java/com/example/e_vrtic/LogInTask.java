package com.example.e_vrtic;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LogInTask extends AsyncTask<String, String, String> {

    private ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {
        Integer statusCode =0;
        try {
            HttpResponse<JsonNode> loginResult = Unirest.get(MainActivity.URL+MainActivity.LOGIN_PATH+"{userId}")
                    .routeParam("userId",
                            MainActivity.username.getText().toString()+"#"+MainActivity.password.getText().toString()).asJson();

            statusCode = loginResult.getStatus();

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return statusCode.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(MainActivity.instance);
        progressDialog.setMessage("Prijavljivanje");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    protected void onPostExecute(String statusCode) {
        progressDialog.dismiss();
        if(statusCode.equals("200")){
            Intent intent = new Intent(MainActivity.instance, MainActivity2.class);
            MainActivity.instance.startActivity(intent);
            Toast.makeText(MainActivity.instance, "Uspješna prijava", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.instance, "Neuspješna prijava!", Toast.LENGTH_SHORT).show();

        }


    }

}