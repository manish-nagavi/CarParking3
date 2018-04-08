package com.example.manis_000.carparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userdetails extends AppCompatActivity {

    private EditText username, emailid, password;
    private Button signup;
    private TextView back;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        setupUIViews();
        mAuth= FirebaseAuth.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userdetails.this, MainActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String user_email= emailid.getText().toString().trim();
                    String user_password= password.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(userdetails.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(userdetails.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(userdetails.this,"Registration unSuccessful",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    public void savegenerate (View view){
        Intent savegen= new Intent(userdetails.this,location.class);
        startActivity(savegen);

    }

    private void setupUIViews(){
        username= (EditText) findViewById(R.id.etusername);
        emailid= (EditText) findViewById(R.id.etenteremail);
        password= (EditText) findViewById(R.id.etenterpassword);
        signup=(Button) findViewById(R.id.btnsignup);
        back=(TextView) findViewById(R.id.etback);
    }

    private Boolean validate(){
        Boolean result=false;

        String name= username.getText().toString();
        String email=emailid.getText().toString();
        String passwor = password.getText().toString();

        if(name.isEmpty() || email.isEmpty() || passwor.isEmpty()){
            Toast.makeText(this,"pls enter all fields",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }
}
