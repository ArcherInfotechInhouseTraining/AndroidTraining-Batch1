package com.example.sqldatabase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_helper extends SQLiteOpenHelper {

    public DB_helper(@Nullable Context context) {
        super(context, "CRUDDataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE UserDetails(name TEXT PRIMARY KEY, contact TEXT, dob TEXT, Address TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqlLiteDatabase, int i, int i1) {

        sqlLiteDatabase.execSQL("DROP TABLE IF EXISTS UserDetails");
        onCreate(sqlLiteDatabase);

    }

    public Boolean insertUserDate(String name, String contact, String dob, String address){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("Address", address);

        long result = DB.insert("UserDetails", null, contentValues);
        return result != -1;
    }

    public Boolean updateUserDate(String name, String contact, String dob, String address){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("Address", address);

        Cursor cursor = DB.rawQuery("SELECT * FROM UserDetails WHERE name = ?", new String[]{name});

        if (cursor.getCount()>0){

            long result = DB.update("UserDetails", contentValues, "name=?", new String[]{name});
            return result != -1;
        }
        else {
            return false;
        }
    }

    public Boolean deleteUserDate(String name){

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELeCT * FROM UserDetails WHERE name=?", new String[]{name});

        if (cursor.getCount() > 0 ){

            long result = DB.delete("UserDetails", "name=?", new String[]{name});
            return result != -1;

        }

        else {
            return false;
        }
    }

    public Cursor readUserDate()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("SELECT * FROM UserDetails", null);
    }
}
