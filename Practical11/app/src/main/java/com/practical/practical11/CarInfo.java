package com.practical.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CarInfo extends AppCompatActivity {

    ImageView imageView;
    TextView title;
    TextView launchDate;
    TextView companyName;
    TextView engine;
    TextView transmission;
    TextView height;
    TextView length;

    Button btnRed;
    Button btnBlack;
    Button btnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);

        imageView=findViewById(R.id.carImage);
        title=findViewById(R.id.title);
        launchDate=findViewById(R.id.launchDate);
        companyName=findViewById(R.id.companyName);
        engine=findViewById(R.id.engineName);
        transmission=findViewById(R.id.transmissionName);
        height=findViewById(R.id.height);
        length=findViewById(R.id.length);

        btnRed=findViewById(R.id.btnColorRed);
        btnBlack=findViewById(R.id.btnColorBlack);
        btnGreen=findViewById(R.id.btnColorGreen);

        Intent intent=getIntent();
        switch (intent.getStringExtra("name")){
            case "benz":
                imageView.setImageResource(R.drawable.benz);
                title.setText("M-101");
                launchDate.setText("22-August-2015");
                companyName.setText("Mercedez");
                engine.setText("3.5 L L539 V8");
                transmission.setText("6-speed semi-automatic");
                height.setText("1.23mm (45.7 in)");
                length.setText("6.780mm (200.2 in)");

                btnRed.setBackgroundColor(Color.RED);
                btnRed.setVisibility(View.VISIBLE);
                btnGreen.setVisibility(View.INVISIBLE);
                btnBlack.setVisibility(View.INVISIBLE);
                break;
            case "city":
                title.setText("City");
                imageView.setImageResource(R.drawable.city);
                launchDate.setText("2-October-2018");
                companyName.setText("Honda");
                engine.setText("2.0 L L539 V4");
                transmission.setText("5-speed automatic");
                height.setText("1.136mm (44.7 in)");
                length.setText("4.780mm (188.2 in)");

                btnRed.setBackgroundColor(Color.WHITE);
                btnRed.setVisibility(View.VISIBLE);
                btnGreen.setVisibility(View.INVISIBLE);
                btnBlack.setVisibility(View.INVISIBLE);
                break;
            case "lambo":
                title.setText("Aventador");
                imageView.setImageResource(R.drawable.lambo);
                launchDate.setText("1-Jan-2012");
                companyName.setText("Lamborghini");
                engine.setText("6.5 L L539 V12");
                transmission.setText("7-speed ISR semi-automatic");
                height.setText("1.136mm (44.7 in)");
                length.setText("4.780mm (188.2 in)");

                btnRed.setBackgroundColor(Color.RED);
                btnGreen.setBackgroundColor(Color.GREEN);
                btnBlack.setBackgroundColor(Color.BLACK);
                btnRed.setVisibility(View.VISIBLE);
                btnGreen.setVisibility(View.VISIBLE);
                btnBlack.setVisibility(View.VISIBLE);
                break;
        }
    }
}
