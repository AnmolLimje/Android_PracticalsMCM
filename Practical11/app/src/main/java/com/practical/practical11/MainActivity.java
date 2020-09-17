package com.practical.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCarList=findViewById(R.id.spinnerList);
        setSpinnerCarList();
    }

    private void setSpinnerCarList(){
        List<String> listAnim=new ArrayList<>();
        listAnim.add("None");
        listAnim.add("Mercedez Benz");
        listAnim.add("Honda City");
        listAnim.add("Lamborghini");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listAnim);
        spinnerCarList.setAdapter(dataAdapter);

        spinnerCarList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (parent.getItemAtPosition(position).toString()){
                    case "Mercedez Benz":
                        intent=new Intent(MainActivity.this,CarInfo.class);
                        intent.putExtra("name","benz");
                        startActivity(intent);
                        break;
                    case "Honda City":
                        intent=new Intent(MainActivity.this,CarInfo.class);
                        intent.putExtra("name","city");
                        startActivity(intent);
                        break;
                    case "Lamborghini":
                        intent=new Intent(MainActivity.this,CarInfo.class);
                        intent.putExtra("name","lamb");
                        startActivity(intent);
                        break;
                }            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
