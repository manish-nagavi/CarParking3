package com.example.manis_000.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void showslots(View view){
        Intent showslots=new Intent (location.this,slots.class);
        startActivity(showslots);
    }

    }
