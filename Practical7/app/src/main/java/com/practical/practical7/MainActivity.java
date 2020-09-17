package com.practical.practical7;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id){
            case R.id.actionRed:
                Toast.makeText(this,"You have Selected Red",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.RED);
                return true;
            case R.id.actionGreen:
                Toast.makeText(this,"You have Selected Green",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                return true;
            case R.id.actionBlue:
                Toast.makeText(this,"You have Selected Green",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
