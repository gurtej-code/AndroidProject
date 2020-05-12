package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    RadioGroup rg;
    RadioButton r1,r2;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        e1=findViewById(R.id.editfirstname);
        e2=findViewById(R.id.editlastname);
        e3=findViewById(R.id.editfathername);
        e4=findViewById(R.id.editaddress);
        e5=findViewById(R.id.editphone);
        e6=findViewById(R.id.editemail);
        e7=findViewById(R.id.editpincode);
        e8=findViewById(R.id.editcity);
        e9=findViewById(R.id.editbloodtype);
        r1=findViewById(R.id.editmale);
        r2=findViewById(R.id.editFemale);

        Intent intent=getIntent();
        s1=intent.getStringExtra("s1");
        s2=intent.getStringExtra("s2");
        s3=intent.getStringExtra("s3");
        s4=intent.getStringExtra("s4");
        s5=intent.getStringExtra("s5");
        s6=intent.getStringExtra("s6");
        s7=intent.getStringExtra("s7");
        s8=intent.getStringExtra("s8");
        s9=intent.getStringExtra("s9");
        s10=intent.getStringExtra("s10");

        if(s10.equals("Male")){
            r1.setChecked(true);
        }else{
            r2.setChecked(true);
        }

        e1.setText(s1);
        e2.setText(s2);
        e3.setText(s3);
        e4.setText(s4);
        e5.setText(s5);
        e6.setText(s6);
        e7.setText(s7);
        e8.setText(s8);
        e9.setText(s9);

    }

    public void UpdateUserDetails(View view){
        DbManager db=new DbManager(this);
        rg = (RadioGroup) findViewById(R.id.editradio_group);
        final String value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        boolean check=db.UpdateUser(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString(),e8.getText().toString(),e9.getText().toString(),value);
        if(check==true){
            Toast.makeText(this,"Data Successfully Updated",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Something Error in server",Toast.LENGTH_LONG).show();
        }
    }
}