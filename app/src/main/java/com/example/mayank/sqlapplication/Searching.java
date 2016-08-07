package com.example.mayank.sqlapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Searching extends AppCompatActivity {

    EditText editText;
    TextView email, number;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        editText = (EditText) findViewById(R.id.nameenter);
        email = (TextView) findViewById(R.id.searchemail);
        number = (TextView) findViewById(R.id.searchnumber);
        email.setVisibility(View.INVISIBLE);
        number.setVisibility(View.INVISIBLE);
    }

    public void search(View view) {
        String search_name = editText.getText().toString();
        Dbhelper dbhelper = new Dbhelper(getApplicationContext());
        sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = dbhelper.searchInformation(search_name, sqLiteDatabase);
        if (cursor.moveToFirst()) {
            String num = cursor.getString(0);
            String mail = cursor.getString(1);
            email.setText(mail.toString());
            number.setText(num.toString());
            email.setVisibility(View.VISIBLE);
            number.setVisibility(View.VISIBLE);
        }
    }

    public void delete(View view) {
        SQLiteDatabase sqLiteDatabase;
        String deletename = editText.getText().toString();
        Dbhelper dbhelper = new Dbhelper(getApplicationContext());
        sqLiteDatabase = dbhelper.getReadableDatabase();
        dbhelper.delete(deletename, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), "Info deleted", Toast.LENGTH_LONG).show();

    }
}
