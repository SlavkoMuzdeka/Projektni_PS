package com.example.e_vrtic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e_vrtic.model.Child;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    public static MainActivity2 instance = null;
    public static ListView listView;
    public static List<Child> list = new ArrayList<>();
    public static ArrayAdapter arrayAdapter;

    {
        instance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Evidencija prisustva");

        listView = findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_multiple_choice, list);
        listView.setAdapter(arrayAdapter);

        LoadPersonsTask loadPersonsTask = new LoadPersonsTask();
        loadPersonsTask.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_done) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("??elite li sa??uvati izmjene?");
            alert.setMessage("Izmjene ostaju trajno sa??uvane!");
            alert.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //Toast.makeText(MainActivity2.this, "Yes", Toast.LENGTH_SHORT).show();
                    UpdatePersonsTask updatePersonsTask = new UpdatePersonsTask();
                    updatePersonsTask.execute();
                }
            });

            alert.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity2.this, "Izmjene nisu sa??uvane", Toast.LENGTH_SHORT).show();
                }
            });

            alert.show();
        }else if (item.getItemId() == R.id.item_refresh){
            LoadPersonsTask loadPersonsTask = new LoadPersonsTask();
            loadPersonsTask.execute();
        }
        return super.onOptionsItemSelected(item);
    }

}