package com.practical.practical13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> smsMessageList=new ArrayList<>();
    ListView smsListView;
    ArrayAdapter arrayAdapter;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(R.id.chronometer1);
        smsListView=findViewById(R.id.listView1);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,smsMessageList);
        smsListView.setAdapter(arrayAdapter);

        if(ContextCompat.checkSelfPermission(getBaseContext(),"android.permission.READ_SMS")== PackageManager.PERMISSION_GRANTED){
            refreshSMSInbox();
        }else{
            final int REQUEST_CODE_ASK_PERMISSONS=123;
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.READ_SMS"},REQUEST_CODE_ASK_PERMISSONS);
        }


        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                refreshSMSInbox();
            }
        });
    }

    private void refreshSMSInbox() {
        ContentResolver contentResolver=getContentResolver();
        Cursor smsInboxCursor=contentResolver.query(Uri.parse("content://sms/inbox"),null,null,null);
        int indexBody=smsInboxCursor.getColumnIndex("body");
        int indexAddress=smsInboxCursor.getColumnIndex("address");
        if(indexBody<0|!smsInboxCursor.moveToFirst()) return;
        arrayAdapter.clear();
        do{
            String str="SMS From: "+smsInboxCursor.getString(indexAddress)+"\n"+smsInboxCursor.getString(indexBody)+"\n";
            arrayAdapter.add(str);
        }while(smsInboxCursor.moveToNext());
    }
}
