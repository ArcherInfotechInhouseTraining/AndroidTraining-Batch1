package com.example.registerandloginsqlite.SQLiteDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(" create table users (username TEXT primary key, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("drop Table if exists users");

    }

    public boolean insertData(String userName, String email, String password){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("userName", userName);
        contentValues.put("email", email);
        contentValues.put("password",password);

        long result = MyDB.insert("users", null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean checkUserName(String userName){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where userName = ?", new String[]{userName});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public boolean checkUserPassword(String userName, String userPassword) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where userName = ? and userPassword = ?", new String[]{userName, userPassword});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
