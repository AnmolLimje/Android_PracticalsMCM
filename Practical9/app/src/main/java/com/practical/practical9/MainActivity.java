package com.practical.practical9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    TextView textView;
    final int duration=10;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=(Chronometer)findViewById(R.id.chronometer);
        textView=(TextView)findViewById(R.id.msg);
        Button start=(Button)findViewById(R.id.button1);
        Button stop=(Button)findViewById(R.id.button2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
                chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        textView.setText("Time Remaining: "+(duration-i)+" Seconds");
                        i++;
                        if(i>=duration){
                            chronometer.stop();
                            i=0;
                            startService(new Intent(getApplicationContext(),MyService.class));
                        }
                    }
                });
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                stopService(new Intent(getApplicationContext(),MyService.class));
            }
        });
    }
}
