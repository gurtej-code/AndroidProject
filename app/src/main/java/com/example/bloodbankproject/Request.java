package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Request extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        e1=findViewById(R.id.nobags);
        e2=findViewById(R.id.requestdate);
        e3=findViewById(R.id.requestbloodgroup);
        e4=findViewById(R.id.requestemail);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }

    public void insetdata1(View view){
        DbManager db = new DbManager(this);
        String res=db.requestofseeker(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        Intent intent=new Intent(this,Seeker.class);
        intent.putExtra("username",username);
        startActivity(intent);

    }
}
