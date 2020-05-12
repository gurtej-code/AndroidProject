package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bloodbankproject.Model.data;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    ListView l1;
    DbManager dbManager;
    ArrayList<data> arrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        l1=(ListView)findViewById(R.id.listview);
        dbManager=new DbManager(this);
        arrayList=new ArrayList<>();
        loadDataInListView();
    }


    private void loadDataInListView() {
        arrayList=dbManager.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
