package com.example.mayank.sqlapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Contactenter extends AppCompatActivity {

    EditText name, no, email;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenter);
        name = (EditText) findViewById(R.id.editText);
        no = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
    }

    public void save(View view) {
        String Name = name.getText().toString();
        String No = no.getText().toString();
        String Email = email.getText().toString();
        Dbhelper dbhelper = new Dbhelper(this);
        sqLiteDatabase = dbhelper.getWritableDatabase();
        dbhelper.addinformation(Name, No, Email, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), "Data Saved!!", Toast.LENGTH_LONG).show();
        dbhelper.close();
        name.setText("");
        no.setText("");
        email.setText("");
    }
}
