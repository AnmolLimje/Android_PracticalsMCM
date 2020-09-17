package com.practical.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText _edtUsername,_edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _edtUsername=(EditText)findViewById(R.id.edtEmail);
        _edtPassword=(EditText)findViewById(R.id.edtPassword);
    }

    public void onClick_btnLogin(View v){
        String checkEmail=_edtUsername.getText().toString();
        boolean isValidEmail=checkEmail.contains("@");

        String password=_edtPassword.getText().toString();
        if(checkEmail.equals("limje.anmol31@gmail.com") && password.equals("abc123")) {
            Toast.makeText(getApplicationContext(), "Welcome Anmol", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this,UserPanel.class);
            intent.putExtra("username",checkEmail);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
