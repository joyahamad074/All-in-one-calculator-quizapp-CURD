package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class quizmain extends AppCompatActivity {
    EditText etname;
    Button stquizbtn;
    String name;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmain);

        getSupportActionBar().setTitle("QuizBee");

        etname=findViewById(R.id.etname);
        stquizbtn=findViewById(R.id.stquizbtn);



    }

    public void stquiz(View view) {
        name=etname.getText().toString();
        if(TextUtils.isEmpty(name)){
            etname.setError("Please Enter Your Name");
            return;
        }
        Intent intent=new Intent(this, quizquestion1.class);
        intent.putExtra("name",name);
        startActivity(intent);
        finish();

    }
}
