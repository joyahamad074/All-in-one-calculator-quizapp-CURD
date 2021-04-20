package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("All In One");
    }

    public void calculate_btn(View view) {
        Intent intent=new Intent(MainActivity.this,calculate.class);
        startActivity(intent);
        finish();
    }

    public void quiz_btn(View view) {
        Intent intent=new Intent(MainActivity.this, quizmain.class);
        startActivity(intent);
        finish();
    }

    public void saveinfo_btn(View view) {
        Intent intent=new Intent(MainActivity.this,saveinfo.class);
        startActivity(intent);
        finish();
    }

}
