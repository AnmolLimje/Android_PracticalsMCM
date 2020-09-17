package com.practical.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText _edtUsername,_edtPassword;
    Button _btnLogin;
    String checkEmail="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _edtUsername= findViewById(R.id.edtEmail);
        _edtPassword= findViewById(R.id.edtPassword);
        _btnLogin= findViewById(R.id.btnLogin);

        _btnLogin.setEnabled(false);

        //Username
        _edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckValidation();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //Password
        _edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckValidation();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void CheckValidation()
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+";
        checkEmail=_edtUsername.getText().toString();
        String pass=_edtPassword.getText().toString();

        if(checkEmail.matches(emailPattern)){
            if(checkEmail.equals("abc@gmail.com") && pass.equals("123")) {
                _btnLogin.setEnabled(true);
            }else{
                _btnLogin.setEnabled(false);
            }
        }
        else{
            _btnLogin.setEnabled(false);
        }
    }

    public void onClick_btnLogin(View v)
    {
        Toast.makeText(getApplicationContext(), "Welcome Anmol", Toast.LENGTH_SHORT).show();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.anmolhost.info/anmolphotography"));
        startActivity(browserIntent);

    }
}
