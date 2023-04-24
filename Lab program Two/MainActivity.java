package com.example.labprogramthree;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button signUp;
    Pattern lower=Pattern.compile("^.*[a-z].*$");
    Pattern upper=Pattern.compile("^.*[A-Z].*$");
    Pattern num=Pattern.compile("^.*[0-9].*$");
    Pattern spec=Pattern.compile("^.*[@#$%^*;!<>(){},.?&/].*$");
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.txtUser);
        pass=findViewById(R.id.txtPass);
        signUp=findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId= user.getText().toString();
                String password= pass.getText().toString();

                if (userId.length()>4&&password.length()>=8) {
                    if(!lower.matcher(password).matches() || !upper.matcher(password).matches() || !num.matcher(password).matches() || !spec.matcher(password).matches()){
                        Toast.makeText(MainActivity.this, "Invalid ", Toast.LENGTH_SHORT).show();
                    } 
                    else 
                    {
                        Toast.makeText(MainActivity.this, "Sign up success", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,Login.class);
                        intent.putExtra("UserName",userId);
                        intent.putExtra("password",password);
                        startActivity(intent);
                }
            }else{
                    Toast.makeText(MainActivity.this, "Invalid Id or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}