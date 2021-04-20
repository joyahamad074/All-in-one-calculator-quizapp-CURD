package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quizquestion3 extends AppCompatActivity {
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    public Button btn;
    int extra,sum,num;
    int radioid;
    public static String extras="3rd";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizquestion3);

        getSupportActionBar().setTitle("Question-3");

        radioGroup=findViewById(R.id.radiogroup);
        Intent mygetintent=getIntent();
        extra=mygetintent.getIntExtra(quizquestion2.extras,0);
        Intent namegetintent=getIntent();
        name=namegetintent.getStringExtra("name");
    }

    public void btn(View view) {

        try {
            radioid=radioGroup.getCheckedRadioButtonId();
            radioButton=findViewById(radioid);
            String text=radioButton.getText().toString();
            if(text.equals("Open Handset Alliance")){
                num=5;
            }
            sum=extra+num;
            Intent intent = new Intent(this,quizresult.class);
            intent.putExtra(extras,sum);
            intent.putExtra("name",name);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, "Select Your Answer First", Toast.LENGTH_SHORT).show();
        }



    }
}
