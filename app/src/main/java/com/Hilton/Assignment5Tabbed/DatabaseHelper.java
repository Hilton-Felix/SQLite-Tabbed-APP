package com.Hilton.Assignment5Tabbed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "UserssDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Usersdetails(fullname TEXT , phoneno TEXT, email TEXT primary key,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Usersdetails");
    }

    //CRUD OPERATIONS

    public Boolean insertUserdata(String fullname, String phoneno, String email ,String address){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("phoneno",phoneno);
        contentValues.put("email", email);
        contentValues.put("address",address);

        long result=DB.insert("Usersdetails",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean updateuserdata(String fullname, String phoneno, String email,String address){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("phoneno", phoneno);
        contentValues.put("email", email);
        contentValues.put("address",address);

        Cursor cursor=DB.rawQuery("Select * from Usersdetails where email=?", new String[]{email});
        if(cursor.getCount()>0) {
            long result = DB.update("Usersdetails", contentValues, "email=?", new String[]{email});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }



    public Boolean deleteuserdata(String email){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("Select * from Userdetails where email=?", new String[]{email});
        if(cursor.getCount()>0) {
            long result = DB.delete("Usersdetails", "email=?", new String[]{email});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("Select * from Usersdetails", null);
        return cursor;
    }
    public  Cursor getUser(String email){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("Select * from Usersdetails where email=?", new String[]{email});
        return cursor;
    }


}
