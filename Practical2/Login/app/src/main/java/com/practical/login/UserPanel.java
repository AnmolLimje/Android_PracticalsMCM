package com.practical.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserPanel extends AppCompatActivity {

    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        txtUser=(TextView)findViewById(R.id.txtuser);

        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        txtUser.setText(username);
    }
}
