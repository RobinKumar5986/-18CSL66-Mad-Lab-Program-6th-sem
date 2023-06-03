package com.example.labprogramseven;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String s;
    TextToSpeech textToSpeech;
    EditText str;
    Button sayIt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str=findViewById(R.id.str);
        sayIt=findViewById(R.id.btnSpeak);

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        sayIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=str.getText().toString();
                if(!s.isEmpty()){
                    textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }else{
                    textToSpeech.speak("There is Nothing to say",TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }
}