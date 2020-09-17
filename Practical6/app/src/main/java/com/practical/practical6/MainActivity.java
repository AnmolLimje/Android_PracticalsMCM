package com.practical.practical6;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtNoOfItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNoOfItems=(TextView)findViewById(R.id.noToDisplay);
    }

    public void btnClickGoToNext(View view){
        Intent intent=new Intent(this,ListActivity.class);
        intent.putExtra("noofitems",Integer.parseInt(txtNoOfItems.getText().toString()));
        startActivity(intent);
    }
}
