package com.practical.practical19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    Button btnRead;
    String filename="/storage/1413-3D1C/file1.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=findViewById(R.id.textView);
        btnRead=findViewById(R.id.button);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file=new File(filename);
                if(file.exists()){
                    showMessage("File Exists");
                    StringBuilder text=new StringBuilder();
                    try{
                        BufferedReader br=new BufferedReader(new FileReader(file));
                        String line;
                        while((line=br.readLine())!=null){
                            text.append(line);
                            text.append('\n');
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        showMessage("File Not Found EXP: "+e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                        showMessage("IO Exp: "+e.getMessage());
                    }

                    txtView.setText(text);
                }else{
                    showMessage("File Not Exists at "+file.getPath());
                }
            }
        });
    }

    private void showMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
