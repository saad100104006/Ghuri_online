package com.online.ghuri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saad on 7/29/16.
 */

public class TextDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    ActionBarDrawerToggle toggle;
   // SQLiteConnector Db;
    List<String> catList;
    List<Integer> smsNumberList = new ArrayList();
    private static final int CAMERA_REQUEST = 1888;

    ImageView imgView;
    String description;
    TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textdetails);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event Description");



        des=(TextView)findViewById(R.id.description);

        Intent intent = getIntent();
        description = intent.getStringExtra("text");

        des.setText(description);


    }
}


