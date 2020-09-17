package com.practical.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    TextView textView;
    int duration=10; //second
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=(Chronometer)findViewById(R.id.cnm);
        textView=(TextView)findViewById(R.id.tv);
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                textView.setText("Message will be displayed after "+(duration - i)+" seconds");
                i++;

                if(i>duration){
                    Toast.makeText(getApplicationContext(),"Hello From Toast Message",Toast.LENGTH_LONG).show();
                    chronometer.stop();
                }
            }
        });
    }
}
