package com.example.labprogramthree;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Intent i;
    EditText userName;
    EditText pass;
    Button Login;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName=findViewById(R.id.txtUserlog);
        pass=findViewById(R.id.txtPasslog);
        Login=findViewById(R.id.btnLogin);
        
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=getIntent();
                String user=i.getStringExtra("UserName");
                String password=i.getStringExtra("password");
                
                String u=userName.getText().toString();
                String p=pass.getText().toString();
                
                if(user.equals(u)&&password.equals(p)){
//                    Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Welcome.class);
                    intent.putExtra("Name",u);
                    startActivity(intent);

                }else{
                    Toast.makeText(Login.this, "Invalid id or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}