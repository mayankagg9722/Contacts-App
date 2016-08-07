package com.example.mayank.sqlapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addcontacts(View view) {
        Intent intent = new Intent(this, Contactenter.class);
        startActivity(intent);
    }

    public void showcontacts(View view) {
        Intent intent = new Intent(this, ViewContacts.class);
        startActivity(intent);
    }

    public void search(View view) {
        Intent intent = new Intent(this, Searching.class);
        startActivity(intent);
    }

    public void updatecontact(View view) {
        Intent intent = new Intent(this, updatecontact.class);
        startActivity(intent);
    }
}
