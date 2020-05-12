package com.example.bloodbankproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
    RadioGroup rg;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.lname);
        e3=(EditText)findViewById(R.id.fname);
        e4=(EditText)findViewById(R.id.address);
        e5=(EditText)findViewById(R.id.phone);
        e6=(EditText)findViewById(R.id.pincode);
        e7=(EditText)findViewById(R.id.city);
        e8=(EditText)findViewById(R.id.bloodtype);
        e9=(EditText)findViewById(R.id.emailid);
        e10=(EditText)findViewById(R.id.pass);
        e11=(EditText)findViewById(R.id.repass);

        b1=findViewById(R.id.submitregister);

    }

    public void login(View view){
        startActivity(new Intent(this,MainActivity.class));
    }



    public void registerrecord(View view){

        if(e1.getText().toString().length()==0){e1.setError("Please Enter First Name");}
        else if(e2.getText().toString().length()==0){e2.setError("Please Enter Last Name");}
        else if(e3.getText().toString().length()==0){e3.setError("Please Enter Father Name");}
        else if(e4.getText().toString().length()==0){e4.setError("Please Enter Address");}
        else if(e5.getText().toString().length()==0){e5.setError("Please Enter Phone Number");}
        else if(e6.getText().toString().length()==0){e6.setError("Please Enter Pincode");}
        else if(e7.getText().toString().length()==0){e7.setError("Please Enter City");}
        else if(e8.getText().toString().length()==0){e8.setError("Please Enter BloodType");}
        else if(e9.getText().toString().length()==0){e9.setError("Please Enter Email-id");}
        else if(!e10.getText().toString().equals(e11.getText().toString())){
            e11.setError("Password Did Not Match");
        }
        else {
            DbManager db = new DbManager(Register.this);
            boolean checkemail=db.checkemail(e9.getText().toString());

            if(checkemail==true) {
                rg = (RadioGroup) findViewById(R.id.radio_group);
                final String value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                String res = db.addRecord(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(), e5.getText().toString(), e9.getText().toString(), e6.getText().toString(), e7.getText().toString(), e8.getText().toString(), value, e10.getText().toString());

                Toast.makeText(Register.this, res, Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e7.setText("");
                e8.setText("");
                e9.setText("");
                e10.setText("");
                e11.setText("");
            }else{
                Toast.makeText(Register.this, "Email Already Exists ", Toast.LENGTH_LONG).show();
            }

        }
    }
}