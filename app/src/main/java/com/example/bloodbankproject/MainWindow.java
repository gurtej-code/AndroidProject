package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainWindow extends AppCompatActivity {
    Button b1,b2;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        b1=findViewById(R.id.donorwindow);
        b2=findViewById(R.id.seekerwindow);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }
    public void jump1(View view){
        Intent intent=new Intent(this,Donor.class);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }


    public void jump2(View view){
        Intent intent=new Intent(this,Seeker.class);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}