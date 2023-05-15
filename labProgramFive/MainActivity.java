package com.example.labprogramfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//---------initialisation--------//
public class MainActivity extends AppCompatActivity {
    private int counter=0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            counter=savedInstanceState.getInt("counter");
            running=savedInstanceState.getBoolean("running");
        }
        runTimer();

    }
    //-----------Main Timer------------//
    private void runTimer() {
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView count=findViewById(R.id.textView);
                count.setText("Count : " + counter);
                if(running) {
                    counter++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    //-------start button--------//
    public void startTimer(View view) {
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
        running=true;
    }
    //-----stop button---------//
    public void stopTimer(View view) {
        Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
        running=false;
    }
    //-----reset button------//
    public void reSetTimer(View view) {
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
        running=false;
        counter=0;
    }


}
