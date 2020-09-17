package com.practical.practical20;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView=new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        //setContentView(R.layout.activity_main);
        setContentView(drawView);
    }

}
