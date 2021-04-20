package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quizquestion2 extends AppCompatActivity {
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    int extra,sum,num;
    int radioid;
    public static String extras="2nd";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizquestion2);

        getSupportActionBar().setTitle("Question-2");

        radioGroup=findViewById(R.id.radiogroup);
        Intent mygetintent=getIntent();
        extra=mygetintent.getIntExtra(quizquestion1.extra,0);
        Intent namegetintent=getIntent();
        name=namegetintent.getStringExtra("name");
    }

    public void btn(View view) {

        try {
            radioid=radioGroup.getCheckedRadioButtonId();
            radioButton=findViewById(radioid);
            String text=radioButton.getText().toString();
            if(text.equals("Mobile Devices")){
                num=5;
            }
            sum=extra+num;
            Intent intent = new Intent(this,quizquestion3.class);
            intent.putExtra(extras,sum);
            intent.putExtra("name",name);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, "Select Your Answer First", Toast.LENGTH_SHORT).show();
        }



    }

}
