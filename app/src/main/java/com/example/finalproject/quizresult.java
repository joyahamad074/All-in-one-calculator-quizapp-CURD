package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class quizresult extends AppCompatActivity {
    public TextView tv2;
    int total=0;
  String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresult);

        getSupportActionBar().setTitle("Result");

        tv2=findViewById(R.id.tv2);
        Intent myintent=getIntent();
        total= myintent.getIntExtra(quizquestion3.extras,0);
        Intent namegetintent=getIntent();
        name=namegetintent.getStringExtra("name");
        if(total==15){
            tv2.setText("Outstanding, "+name+"\n\nYour Score: "+total+" out of 15");
        }
        else if(total==10){
            tv2.setText("Good, "+name+"\n\nYour Score: "+total+" out of 15");
        }

        else if(total==5){
            tv2.setText("Average, "+name+"\n\nYour Score: "+total+" out of 15");
        }

        else{

            tv2.setText("Fail, "+name+"\n\nYour Score: "+total+" out of 15");
        }



    }

    public void btn(View view) {
        Intent intent=new Intent(this,quizmain.class);
        startActivity(intent);
    }
}
