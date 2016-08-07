package com.example.mayank.sqlapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updatecontact extends AppCompatActivity {

    EditText name, number, email, oldname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatecontact);
        name = (EditText) findViewById(R.id.newname);
        number = (EditText) findViewById(R.id.newno);
        email = (EditText) findViewById(R.id.newemail);
        oldname = (EditText) findViewById(R.id.oldname);
    }

    public void showbeforeupdate(View view) {
        Cursor cursor;
        SQLiteDatabase sqLiteDatabase;
        Dbhelper dbhelper = new Dbhelper(getApplicationContext());
        sqLiteDatabase = dbhelper.getReadableDatabase();
        String old = oldname.getText().toString();
        cursor = dbhelper.showupdate(old, sqLiteDatabase);
        if (cursor.moveToFirst()) {
            name.setText(cursor.getString(0).toString());
            number.setText(cursor.getString(1).toString());
            email.setText(cursor.getString(2).toString());
        }

    }

    public void update(View view) {
        Dbhelper dbhelper = new Dbhelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        String newname = name.getText().toString();
        String newnumber = number.getText().toString();
        String newemail = email.getText().toString();
        dbhelper.update(newname, newnumber, newemail, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), "Contact Updated", Toast.LENGTH_LONG).show();
    }
}
