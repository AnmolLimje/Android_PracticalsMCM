package com.practical.practical25;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="dbCred";
    public static final String TAB_NAME="UserCredential";
    public static final String COL_ID="ID";
    public static final String COL_USERNAME="USERNAME";
    public static final String COL_PASSWORD="PASSWORD";

    private Context context;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;

        db=this.getWritableDatabase();
        Toast.makeText(context,"Database Created",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+TAB_NAME+" ("+COL_ID+" integer primary key autoincrement,"+COL_USERNAME+" text,"+COL_PASSWORD+" text)");
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TAB_NAME);
        Toast.makeText(context, "Table Dropped", Toast.LENGTH_SHORT).show();
    }

    //Return True if Succesfully Inserted Value
    public boolean insertData(String Name,String Address){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_USERNAME,Name);
        contentValues.put(COL_PASSWORD,Address);
        long isInserted=db.insert(TAB_NAME,null,contentValues);
        if(isInserted!=-1) {
            return true;
        }else{
            return false;
        }
    }
}
