package com.practical.practical15;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="dbUser";
    public static final String TAB_NAME="tbUserCred";
    public static final String COL_ID="ID";
    public static final String COL_USERNAME="Username";
    public static final String COL_PASSWORD="Password";

    private Context context;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1); //Create Database
        this.context = context;

        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Table
        db.execSQL("Create table "+TAB_NAME+" ("+COL_ID+" integer primary key autoincrement, "+COL_USERNAME+" text,"+COL_PASSWORD+" text)");
        Toast.makeText(context,"Table Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TAB_NAME);
        Toast.makeText(context,"Table Dropped",Toast.LENGTH_SHORT).show();
    }

    public boolean InsertData(String Username,String Password){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_USERNAME,Username);
        contentValues.put(COL_PASSWORD,Password);
        long isInserted=db.insert(TAB_NAME,null,contentValues);
        if(isInserted!=-1){
            return true;
        }else return false;
    }
}
