package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeEditProfile extends AppCompatActivity {
    EditText e1,e2,e3;
    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_edit_profile);
        e1=findViewById(R.id.etempid);
        e2=findViewById(R.id.etempdesignation);
        e3=findViewById(R.id.etempbranch);
        Intent intent=getIntent();
        s1=intent.getStringExtra("s1");
        s2=intent.getStringExtra("s2");
        s3=intent.getStringExtra("s3");
        e1.setText(s1);
        e2.setText(s2);
        e3.setText(s3);
    }

    public void UpdateEmployeeDetails(View view){
        DbManager db=new DbManager(this);
        boolean check=db.UpdateEmp(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
        if(check==true){
            Toast.makeText(this,"Data Sucessfully Updated",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,EmpMainWindow.class);
            intent.putExtra("username",e1.getText().toString());
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,"There is Something Error",Toast.LENGTH_LONG).show();
        }
    }
}
