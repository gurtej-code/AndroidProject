package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Seeker extends AppCompatActivity {
    Button b1,b2,b3;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker);
        b1=findViewById(R.id.request);
        b2=findViewById(R.id.editseeker);
        b3=findViewById(R.id.searchseeker);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }

    public void request(View view){
        Intent intent=new Intent(this,Request.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void seekereditprofile(View view){
        DbManager db = new DbManager(this);
        boolean checkemail=db.checkemail(username);
        if(checkemail==true){
            Toast.makeText(this,"Data couldn't find",Toast.LENGTH_LONG).show();
        }
        else{
            Cursor cursor=db.getinformation(username);
            s1=cursor.getString(0);
            s2=cursor.getString(1);
            s3=cursor.getString(2);
            s4=cursor.getString(3);
            s5=cursor.getString(4);
            s6=cursor.getString(5);
            s7=cursor.getString(6);
            s8=cursor.getString(7);
            s9=cursor.getString(8);
        }

        Intent intent=new Intent(this,EditProfile.class);
        intent.putExtra("s1",s1);
        intent.putExtra("s2",s2);
        intent.putExtra("s3",s3);
        intent.putExtra("s4",s4);
        intent.putExtra("s5",s5);
        intent.putExtra("s6",s6);
        intent.putExtra("s7",s7);
        intent.putExtra("s8",s8);
        intent.putExtra("s9",s9);
        startActivity(intent);
    }

    public void seekersearch(View view){startActivity(new Intent(this,Search1.class));}

    public void seekerlogout(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}