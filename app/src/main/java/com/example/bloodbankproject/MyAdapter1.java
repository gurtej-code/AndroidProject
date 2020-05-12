package com.example.bloodbankproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bloodbankproject.Model.data;
import com.example.bloodbankproject.Model.data1;

import java.util.ArrayList;

public class MyAdapter1 extends BaseAdapter {
    Context context;
    ArrayList<data1> arrayList;

    public MyAdapter1(Context context, ArrayList<data1> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customviewlistone, null);
        TextView t1_blood = (TextView) convertView.findViewById(R.id.dbloodgroup);
        TextView t1_email = (TextView) convertView.findViewById(R.id.demail);


        data1 v1 = arrayList.get(position);
        t1_blood.setText(v1.getBloodgroup());
        t1_email.setText(v1.getEmail());

        return convertView;

    }
}
