package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class quizquestion1 extends AppCompatActivity {
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    int num=0,radioid;
    public static final String extra="1st";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizquestion1);

        getSupportActionBar().setTitle("Question-1");

        radioGroup=findViewById(R.id.radiogroup);
        Intent namegetintent=getIntent();
        name=namegetintent.getStringExtra("name");

    }

    public void btn(View view) {

            try {
                radioid=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioid);
                String text=radioButton.getText().toString();
                if(text.equals("Linux")){
                    num=5;
                }

                Intent intent = new Intent(this,quizquestion2.class);
                intent.putExtra(extra,num);
                intent.putExtra("name",name);
                startActivity(intent);
                finish();

            }catch(Exception e){
                Toast.makeText(this, "Select Your Answer First", Toast.LENGTH_SHORT).show();

            }



    }
}
