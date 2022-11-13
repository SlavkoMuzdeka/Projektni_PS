package com.example.e_vrtic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://192.168.186.106:8080/Android/api/";
    public static final String LOGIN_PATH = "teacherLogIn/";
    public static final String PERSONS_PATH = "childEvidence/";
    public static TextView username;
    public static TextView password;
    public static MainActivity instance;

    {
        instance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInTask logInTask = new LogInTask();
                logInTask.execute();
            }
        });
    }




}