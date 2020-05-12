package com.example.bloodbankproject;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    String s1,s2;
    DbManager db = new DbManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
    }

    public void register(View view){startActivity(new Intent(this,Register.class));}

    public void check(View view){
        s1=e1.getText().toString();
        s2=db.validate(s1);
        if(s2.equals(e2.getText().toString())){
            Toast.makeText(this,"Successfully Login",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,MainWindow.class);
            intent.putExtra("username",e1.getText().toString());
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,"Please Check Username or Password",Toast.LENGTH_LONG).show();
        }

    }

    public void openDialog(View view){
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
        View mView=getLayoutInflater().inflate(R.layout.layout_dialog,null);
        mBuilder.setView(mView);
        final AlertDialog dialog=mBuilder.create();
        dialog.show();

        Button b1=dialog.findViewById(R.id.emplogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e3=dialog.findViewById(R.id.empusername);
                e4=dialog.findViewById(R.id.emppassword);
                String username=e3.getText().toString();
                String password=e4.getText().toString();
                employeelogin(username,password);
            }
        });
    }

    public void jumpregister(View view){
        startActivity(new Intent(this,EmployeeRegister.class));
    }

    public void employeelogin(String user,String pass) {
        String password=db.validate1(user);
        if(password.equals(pass)){
            Toast.makeText(this,"Successfully Login",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,EmpMainWindow.class);
            intent.putExtra("username",user);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,"Please Check Username or Password",Toast.LENGTH_LONG).show();
        }
    }
}