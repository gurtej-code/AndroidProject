package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EmployeeRegister extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_register);
        e1=findViewById(R.id.empid);
        e2=findViewById(R.id.emppass);
        e3=findViewById(R.id.emprepass);
        e4=findViewById(R.id.empdesignation);
        e5=findViewById(R.id.empbranch);
    }

    public void employeeregisterrecord(View view){
        if(!e2.getText().toString().equals(e3.getText().toString())){
         Toast.makeText(this,"Password Does not Match",Toast.LENGTH_LONG).show();
        }
        else {
            DbManager db = new DbManager(this);
            boolean checkempid = db.checkempid(e1.getText().toString());
            if (checkempid == true) {
                String res = db.EmployeeRegister(e1.getText().toString(), e2.getText().toString(),e4.getText().toString(),e5.getText().toString());
                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                startActivity(new Intent(this,MainActivity.class));
            } else {
                Toast.makeText(this, "Employee Already Exists ", Toast.LENGTH_LONG).show();
            }
        }
    }
}
