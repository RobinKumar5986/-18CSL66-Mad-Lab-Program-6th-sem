package com.example.labprogrameight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

//----put it by your self----//
import android.Manifest;
//--------------------------//
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int CALL_PERMISSION=1;
    Button call,save;
    EditText numbers;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=findViewById(R.id.btnCall);
        save=findViewById(R.id.btnSave);
        numbers=findViewById(R.id.number);



//----------------CALLING FEATURE-------------------------------//
        String permission=Manifest.permission.CALL_PHONE;
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission},CALL_PERMISSION);
        }
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!numbers.getText().toString().isEmpty()) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numbers.getText().toString()));
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e ){
                    Toast.makeText(MainActivity.this,"Permission not granted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //----------SAVING FEATURE------------------------//
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=numbers.getText().toString();
                if(!phone.isEmpty()) {
                    Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                    startActivityForResult(contactIntent, 1);
                    Toast.makeText(MainActivity.this,"Number Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Enter the number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}