package com.example.labprogramsix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnXML,btnJASON;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnXML=findViewById(R.id.btnXML);
        btnJASON=findViewById(R.id.btnJASON);
        //XML button
        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,viewJsonData.class);
                intent.putExtra("Type",1);
                startActivity(intent);
            }
        });

        //JSON Button
        btnJASON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,viewJsonData.class);
                intent.putExtra("Type",2);
                startActivity(intent);
            }
        });
    }
}