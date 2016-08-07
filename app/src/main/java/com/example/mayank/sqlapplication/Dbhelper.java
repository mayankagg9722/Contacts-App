package com.example.mayank.sqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mayank on 26-07-2016.
 */
public class Dbhelper extends SQLiteOpenHelper {
    public static final String Database_name = "userinfo.DB";
    public static final int Database_version = 1;
    public static final String Create_Query = "CREATE TABLE " + UserContractor.NewUserInfo.Table_name + "(" + UserContractor.NewUserInfo.User_name + " TEXT," +
            UserContractor.NewUserInfo.User_no + " TEXT," + UserContractor.NewUserInfo.User_email + " TEXT);";

    public Dbhelper(Context context) {
        super(context, Database_name, null, Database_version);
        Log.e("Databaseoperation", "Database created created..");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Query);
        Log.e("Databaseoperation", "Table created..");
    }

    public void addinformation(String name, String number, String email, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContractor.NewUserInfo.User_name, name);
        contentValues.put(UserContractor.NewUserInfo.User_no, number);
        contentValues.put(UserContractor.NewUserInfo.User_email, email);
        sqLiteDatabase.insert(UserContractor.NewUserInfo.Table_name, null, contentValues);
        Log.e("Databaseoperation", "one row inserted ..");

    }

    public Cursor getInformation(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor;
        String[] projection = {UserContractor.NewUserInfo.User_name, UserContractor.NewUserInfo.User_no, UserContractor.NewUserInfo.User_email};
        cursor = sqLiteDatabase.query(UserContractor.NewUserInfo.Table_name, projection, null, null, null, null, null);
        return cursor;
    }

    public Cursor searchInformation(String user_name, SQLiteDatabase sqLiteDatabase) {
        Cursor cursor;
        String[] projection = {UserContractor.NewUserInfo.User_no, UserContractor.NewUserInfo.User_email};
        String selection = UserContractor.NewUserInfo.User_name + " LIKE ?";
        String selection_arguments = user_name;
        cursor = sqLiteDatabase.query(UserContractor.NewUserInfo.Table_name, projection, selection, new String[]{selection_arguments}, null, null, null);
        return cursor;
    }

    public void delete(String name, SQLiteDatabase sqLiteDatabase) {
        String selection = UserContractor.NewUserInfo.User_name + " LIKE ?";
        String selection_arguments = name;
        sqLiteDatabase.delete(UserContractor.NewUserInfo.Table_name, selection, new String[]{selection_arguments});
    }

    public Cursor showupdate(String u_name, SQLiteDatabase sqLiteDatabase) {

        Cursor cursor;
        String[] projection = {UserContractor.NewUserInfo.User_name, UserContractor.NewUserInfo.User_no, UserContractor.NewUserInfo.User_email};
        String selection = UserContractor.NewUserInfo.User_name + " LIKE ?";
        String select_args = u_name;
        cursor = sqLiteDatabase.query(UserContractor.NewUserInfo.Table_name, projection, selection, new String[]{select_args}, null, null, null);
        return cursor;
    }


    public void update(String name, String number, String email, SQLiteDatabase sqLiteDatabase) {
        String selection = UserContractor.NewUserInfo.User_name + " LIKE ?";
        String select_arg = name;
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContractor.NewUserInfo.User_name, name);
        contentValues.put(UserContractor.NewUserInfo.User_no, number);
        contentValues.put(UserContractor.NewUserInfo.User_email, email);
        sqLiteDatabase.update(UserContractor.NewUserInfo.Table_name, contentValues, selection, new String[]{select_arg});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserContractor.NewUserInfo.Table_name);
        onCreate(sqLiteDatabase);
    }
}
