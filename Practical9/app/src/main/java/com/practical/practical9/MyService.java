package com.practical.practical9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Chronometer;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"My Service Started",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Intent dialogIntent=new Intent(getBaseContext(),NextActivity.class);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(dialogIntent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"My Service Stopped",Toast.LENGTH_LONG).show();
    }
}
