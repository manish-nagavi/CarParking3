package com.example.manis_000.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etuseremail);
        password = (EditText) findViewById(R.id.etpassword);
        login = (Button) findViewById(R.id.btnlogin);
        registration= (TextView) findViewById(R.id.etregister);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,userdetails.class));
            }
        });
    }

    public void doregistration (View view){
        Intent details= new Intent(MainActivity.this,userdetails.class);
        startActivity(details);
    }
}
