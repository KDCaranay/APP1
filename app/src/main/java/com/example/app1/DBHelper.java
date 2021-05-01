package com.example.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String  DBNAME = "Login.db";
    private SQLiteDatabase MyDB;

    public DBHelper( Context context, {
        super(context, "Login.db" ,  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)")
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exist users");
    }

    public Boolean InsertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put("username", username);
        ContentValues.put("password",password);
        if(result == -1)
            return false;
        else
            return true;





    }

    public Boolean checkusername (String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery( "Select * from users where username = ?" , new String[] (username));
        if(cursor.getCount()>0)
            return true;
         else
             return false;

    }

    public Boolean checkusernamepassowrd (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?" and password = ?, new String)[] (username,password));
        if(cursor.getCount()>0)
            return true;
        else
            return false;



    }

    public Boolean inserData(String user, String pass) {
    }
}
}
