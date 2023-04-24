package com.example.labprogramthree;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    Intent i;
    TextView t;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t=findViewById(R.id.textView);

        i=getIntent();
        t.setText(t.getText()+i.getStringExtra("Name"));
    }
}