package com.practical.practical15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    Button btnSave;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername=findViewById(R.id.editText);
        txtPassword=findViewById(R.id.editText2);
        btnSave=findViewById(R.id.button);

        databaseHelper=new DatabaseHelper(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(databaseHelper.InsertData(txtUsername.getText().toString(),txtPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),"User Credentials Saved",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"User Credentials Not Saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
