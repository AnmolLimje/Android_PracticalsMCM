package com.practical.practical14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        btnCall=findViewById(R.id.button);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(getBaseContext(),"android.permission.CALL_PHONE")== PackageManager.PERMISSION_GRANTED){
                    Intent callIntent=new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+editText.getText().toString()));
                    startActivity(callIntent);
                }else{
                    final int REQUEST_CODE_ASK_PERMISSONS=123;
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.CALL_PHONE"},REQUEST_CODE_ASK_PERMISSONS);
                }
            }
        });

    }


}
