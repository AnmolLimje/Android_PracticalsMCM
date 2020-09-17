package com.practical.practical16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    Button btnReadAssetFile,btnWriteToExternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=findViewById(R.id.txtView);
        btnReadAssetFile=findViewById(R.id.btnRead);
        btnWriteToExternal=findViewById(R.id.btnWriteToExternal);

        //To Read File
        btnReadAssetFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    txtView.setText(ReadFile());
            }
        });

        //To Write File
        btnWriteToExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    WriteFileSDCard();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"IO Exception",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //read File From Asset Folder
    private String ReadFile() {
        String str="";
        try{
            InputStream inputStream = getAssets().open("mytext.txt", MODE_PRIVATE);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str = new String(buffer);
        }
        catch (IOException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"IO Exception",Toast.LENGTH_LONG).show();
        }
        return str;
    }

    //Read From Asset and Write Data in SD Card
    private void WriteFileSDCard() throws IOException {
        String reserve_state=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(reserve_state)){
            File sdcard=getExternalFilesDir(null);
            File directory=new File(sdcard.getAbsolutePath()+"/myfiles");
            directory.mkdir();
            File file=new File(directory,"copytext.txt");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(ReadFile());
            Toast.makeText(this,"Copied:"+directory.getPath(),Toast.LENGTH_LONG).show();
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(reserve_state)){
            Toast.makeText(this,"Media Mounted as Read-Only",Toast.LENGTH_LONG).show();
        }
    }
}
