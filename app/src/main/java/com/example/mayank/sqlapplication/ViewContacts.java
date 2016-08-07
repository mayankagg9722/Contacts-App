package com.example.mayank.sqlapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewContacts extends AppCompatActivity {
    public static final String Tag = "tag";
    ListView listView;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("tag", "inviewwindow");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        listView = (ListView) findViewById(R.id.listView);
        Dbhelper dbhelper = new Dbhelper(getApplicationContext());
        customArrayAdapter = new CustomArrayAdapter(this, R.layout.row_layout);
        sqLiteDatabase = dbhelper.getReadableDatabase();
        cursor = dbhelper.getInformation(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(0);
                String no = cursor.getString(1);
                String email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name, no, email);
                customArrayAdapter.add(dataProvider);
            } while (cursor.moveToNext());
        }
        listView.setAdapter(customArrayAdapter);
    }
}
