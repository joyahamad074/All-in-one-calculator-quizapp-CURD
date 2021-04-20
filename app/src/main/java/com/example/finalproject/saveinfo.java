package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class saveinfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etid,etname,etemail,etphone,etsearch,etdelete;
    Button savebtn,viewbtn,searchbtn,deletebtn;
    Spinner spgender;
    String idtxt,nametxt,emailtxt,phonetxt,searchtxt,deletetxt,gendertxt;
    DBhelper db;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveinfo);

        getSupportActionBar().setTitle("Save Info");

        etid=findViewById(R.id.etid);
        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etphone=findViewById(R.id.etphone);
        etsearch=findViewById(R.id.etsearch);
        etdelete=findViewById(R.id.etdelete);

        savebtn=findViewById(R.id.savebtn);
        viewbtn=findViewById(R.id.viewbtn);
        searchbtn=findViewById(R.id.searchbtn);
        deletebtn=findViewById(R.id.deletebtn);
        db=new DBhelper(this);

        spgender=findViewById(R.id.sp1gender);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spgender.setAdapter(adapter);
        spgender.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         gendertxt=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void savebtn(View view) {
        idtxt=etid.getText().toString();
        nametxt=etname.getText().toString();
        emailtxt=etemail.getText().toString();
        phonetxt=etphone.getText().toString();

        if(idtxt.isEmpty()){
            etid.setError("ID is required");
            etid.requestFocus();
            return;
        }

        if(nametxt.isEmpty()){
            etname.setError("Name is required");
            etname.requestFocus();
            return;
        }

        if(emailtxt.isEmpty()){
            etemail.setError("Email is required");
            etemail.requestFocus();
            return;
        }

        if(phonetxt.isEmpty()){
            etphone.setError("Phone is required");
            etphone.requestFocus();
            return;
        }
        if(gendertxt.matches("Select Gender..")){
            Toast.makeText(this, "select your gender", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Boolean checkdata=db.insertdata(idtxt,nametxt,emailtxt,phonetxt,gendertxt);
            if(checkdata==true){
                Toast.makeText(this, "Your information is saved", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Information didn't saved/may be it already exists", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void viewbtn(View view) {
        Cursor res=db.viewdata();
        if(res.getCount()==0){
            Toast.makeText(this, "No entry exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID: "+res.getString(0)+"\n");
            buffer.append("Name: "+res.getString(1)+"\n");
            buffer.append("Email: "+res.getString(2)+"\n");
            buffer.append("Phone: "+"+880"+res.getString(3)+"\n");
            buffer.append("Gender: "+res.getString(4)+"\n\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("User Info");
        builder.setMessage(buffer.toString());
        builder.show();
    }

    public void searchbtn(View view) {
        searchtxt=etsearch.getText().toString();
        if(searchtxt.isEmpty()){
            etsearch.setError("ID is required");
            etsearch.requestFocus();
            return;
        }
        Cursor searchres=db.searchdata(searchtxt);
        if(searchres.getCount()==0){
            Toast.makeText(this, "No records found", Toast.LENGTH_SHORT).show();
        }
        StringBuffer buffer=new StringBuffer();
        while (searchres.moveToNext()){
            buffer.append("ID: "+searchres.getString(0)+"\n");
            buffer.append("Name: "+searchres.getString(1)+"\n");
            buffer.append("Email: "+searchres.getString(2)+"\n");
            buffer.append("Phone: "+"+880"+searchres.getString(3)+"\n");
            buffer.append("Gender: "+searchres.getString(4)+"\n\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Found User");
        builder.setMessage(buffer.toString());
        builder.show();
    }

    public void deletebtn(View view) {
        deletetxt=etdelete.getText().toString();
        if(deletetxt.isEmpty()){
            etdelete.setError("ID is required");
            etdelete.requestFocus();
            return;
        }
        Integer deleterows=db.deletedata(deletetxt);
        if(deleterows>0){
            Toast.makeText(this, "Data is deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Data is not exists", Toast.LENGTH_SHORT).show();
        }
    }
}
