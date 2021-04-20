package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table userinfo(id TEXT primary key,name TEXT,email TEXT,phone INTEGER,gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop Table if exists userinfo");
      onCreate(db);
    }
    public Boolean insertdata(String id,String name,String email,String phone,String gender){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("gender",gender);

        long result=db.insert("userinfo",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor viewdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor viewcursor=db.rawQuery("Select * from userinfo",null);
        return viewcursor;
    }

    public Cursor searchdata(String searchtxt){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor searchcursor=db.rawQuery("Select * from userinfo where id='"+searchtxt+"'",null);
        return searchcursor;
    }

    public Integer deletedata(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("userinfo","id = ?",new String[]{id});
    }
}

