package com.example.bloodbankproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bloodbankproject.Model.data;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<data> arrayList;

    public MyAdapter(Context context, ArrayList<data> arrayList) {
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
        convertView = inflater.inflate(R.layout.customeviewlist, null);
        TextView t1_bags = (TextView) convertView.findViewById(R.id.requestbags);
        TextView t1_date = (TextView) convertView.findViewById(R.id.requestdate);
        TextView t1_blood = (TextView) convertView.findViewById(R.id.requestbloodgroup);
        TextView t1_email = (TextView) convertView.findViewById(R.id.requestemail);


        data v1 = arrayList.get(position);
        t1_bags.setText(v1.getName());
        t1_date.setText(v1.getDate());
        t1_blood.setText(v1.getBloodgroup());
        t1_email.setText(v1.getEmail());

        return convertView;

    }
}