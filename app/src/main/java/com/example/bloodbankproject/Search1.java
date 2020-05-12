package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bloodbankproject.Model.data;
import com.example.bloodbankproject.Model.data1;

import java.util.ArrayList;

public class Search1 extends AppCompatActivity {
    ListView l1;
    DbManager dbManager;
    ArrayList<data1> arrayList;
    MyAdapter1 myAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search1);
        l1=(ListView)findViewById(R.id.listview1);
        dbManager=new DbManager(this);
        arrayList=new ArrayList<>();
        loadDataInListView();
    }

    private void loadDataInListView() {
        arrayList=dbManager.getAllData1();
        myAdapter1=new MyAdapter1(this,arrayList);
        l1.setAdapter(myAdapter1);
        myAdapter1.notifyDataSetChanged();
    }
}
