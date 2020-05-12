package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Donate extends AppCompatActivity {
    EditText e1,e2,e3;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        e1=findViewById(R.id.donoremail);
        e2=findViewById(R.id.date);
        e3=findViewById(R.id.donorbloodgroup);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }

    public void insertdata(View view){

        DbManager db = new DbManager(this);
        String res=db.insertintodonate(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        Intent intent=new Intent(this,Donor.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
