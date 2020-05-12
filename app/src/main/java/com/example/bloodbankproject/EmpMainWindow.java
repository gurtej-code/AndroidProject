package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmpMainWindow extends AppCompatActivity {
    String username,s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_main_window);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }
    public void listofdonor(View view){
        startActivity(new Intent(this,Search.class));
    }
    public void listofseeker(View view){
        startActivity(new Intent(this,Search1.class));
    }

    public void empeditprofile(View view){
        DbManager db = new DbManager(this);
        boolean empid=db.checkempid(username);
        if(empid==true){
            Toast.makeText(this,"Data couldn't find",Toast.LENGTH_LONG).show();
        }
        else{
            Cursor cursor=db.getempinformation(username);
            s1=cursor.getString(0);
            s2=cursor.getString(1);
            s3=cursor.getString(2);
        }
        Intent intent=new Intent(this,EmployeeEditProfile.class);
        intent.putExtra("s1",s1);
        intent.putExtra("s2",s2);
        intent.putExtra("s3",s3);
        startActivity(intent);
    }

    public void emplogout(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
