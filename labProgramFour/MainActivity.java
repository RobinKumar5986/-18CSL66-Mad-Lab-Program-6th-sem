package com.example.labprogramfour;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
//--we can directly use the on click method on the button--//
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    boolean running;
    int[] ia={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.foure,R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!running){
               new Timer().schedule(new MyTimer(),0,300);
               running=true;
        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try {
                WallpaperManager manager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                manager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            }catch (Exception e){
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
