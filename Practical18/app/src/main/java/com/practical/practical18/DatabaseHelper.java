package com.practical.practical18;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="dbWork";
    public static final String TAB_NAME="tb1";
    public static final String COL_ID="ID";
    public static final String COL_NAME="NAME";
    public static final String COL_ADDRESS="ADDRESS";

    private Context context;
    private SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
        this.context=context;

        //Create Database and table
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TAB_NAME+" ("+COL_ID+" integer primary key autoincrement, "+COL_NAME+" text,"+COL_ADDRESS+" text)");
        Toast.makeText(context,"table Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TAB_NAME);
        Toast.makeText(context,"Table Dropped",Toast.LENGTH_SHORT).show();
    }

    //Predict Increment Data from AutoIncrement Column
    public int getNextID(){
        Cursor cursor=db.rawQuery("SELECT MAX("+COL_ID.toString()+") AS max_id from "+TAB_NAME,null);
        int id=0;
        if(cursor.getCount()==0){
            return id;
        }
        while(cursor.moveToNext()){
            id=cursor.getInt(0);
        }

        return id+1;
    }

    //Predict Increment Data from AutoIncrement Column
    public String[] getSingleData(String ID){
        String[] singleData=new String[3];
        Cursor cursor=db.rawQuery("SELECT * from "+TAB_NAME+" where ID="+ID,null);
        if(cursor==null){
            return singleData;
        }
        while(cursor.moveToNext()){
            singleData[0]=cursor.getString(0);
            singleData[1]=cursor.getString(1);
            singleData[2]=cursor.getString(2);
        }

        return singleData;
    }

    //To Fetch All ID in the SpinnerDrop Down List
    public List<String> getAllID(){
        List<String> list = new ArrayList<String>();
        list.add("Search");
        Cursor cursor=db.rawQuery("SELECT ID FROM "+TAB_NAME,null);

        if(cursor.getCount()==0){
            return list;
        }
        while(cursor.moveToNext()){
            list.add(cursor.getString(0));
        }
        return list;
    }

    //Return True if Succesfully Inserted Value
    public boolean insertData(String Name,String Address){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME,Name);
        contentValues.put(COL_ADDRESS,Address);
        long isInserted=db.insert(TAB_NAME,null,contentValues);
        if(isInserted!=-1) {
            return true;
        }else{
            return false;
        }
    }

    //Returns Truw if Successfully Updated Value
    public boolean updateData(Integer ID, String Name,String Address){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME,Name);
        contentValues.put(COL_ADDRESS,Address);
        long isUpdated=db.update(TAB_NAME,contentValues,COL_ID+"="+ID.toString(),null);
        if(isUpdated>0) {
            return true;
        }else{
            return false;
        }
    }

    //Returns True if Successfully Delete Value
    public boolean deleteData(Integer ID){
        long isDeleted=db.delete(TAB_NAME,COL_ID+"="+ID.toString(),null);
        if(isDeleted>0) {
            return true;
        }else{
            return false;
        }
    }

    //Get All Data
    public Cursor getAllData(){
        return db.rawQuery("Select * from "+TAB_NAME,null);
    }

}
