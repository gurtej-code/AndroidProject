package com.example.bloodbankproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bloodbankproject.Model.data;
import com.example.bloodbankproject.Model.data1;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname = "BloodBank.db";

    public DbManager(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table Register(FirstName text not null, LastName text not null,FatherName text not null,Address text not null,PhoneNo text not null,Email text not null,Pincode text not null,City text not null,BloodType text not null,Gender text not null,Password text not null)";
        String qry1 = "create table DonateBlood(Email text not null,Date text not null,BloodGroup text not null)";
        String qry2 = "create table RequestBlood(Bags text not null,Date text not null,BloodGroup text not null,Email text not null)";
        String qry3 = "create table EmployeeDetails(EmployeeId text not null,Designation text not null,Branch text not null,Password text not null)";
        sqLiteDatabase.execSQL(qry);
        sqLiteDatabase.execSQL(qry1);
        sqLiteDatabase.execSQL(qry2);
        sqLiteDatabase.execSQL(qry3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Register");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DonateBlood");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS RequestBlood");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS EmployeeDetails");

        onCreate(sqLiteDatabase);
    }

    public String addRecord(String FirstName, String LastName, String FatherName, String Address, String PhoneNo, String Email, String Pincode, String City, String BloodType, String Gender, String Passowrd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FirstName", FirstName);
        cv.put("LastName", LastName);
        cv.put("FatherName", FatherName);
        cv.put("Address", Address);
        cv.put("PhoneNo", PhoneNo);
        cv.put("Email", Email);
        cv.put("Pincode", Pincode);
        cv.put("City", City);
        cv.put("BloodType", BloodType);
        cv.put("Gender", Gender);
        cv.put("Password", Passowrd);

        long res = db.insert("Register", null, cv);
        if (res == -1)
            return "Something Went Wrong";
        else
            return "Successsfully Register";

    }


    public String insertintodonate(String Email,String Date,String BloodGroup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Email", Email);
        cv.put("Date", Date);
        cv.put("BloodGroup", BloodGroup);

        long res = db.insert("DonateBlood", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Thanks For Donating";
    }

    public String requestofseeker(String Bags,String Date,String BloodGroup,String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Bags", Bags);
        cv.put("Date", Date);
        cv.put("BloodGroup", BloodGroup);
        cv.put("Email", Email);

        long res = db.insert("RequestBlood", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Your Request Successfully Submitted";
    }

    public boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Register where Email=?", new String[]{email});

        if (cursor.getCount() > 0) return false;
        else return true;
    }


    public String validate(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select Email,Password from Register", null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(email)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    public Cursor getinformation(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Register where Email=?",new String[]{username});
        if(cursor!=null){
            cursor.moveToNext();
        }
        return cursor;
    }

    public ArrayList<data> getAllData() {
        ArrayList<data> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("Select * from RequestBlood", null);

        while (result.moveToNext()) {
            String name = result.getString(0);
            String date = result.getString(1);
            String bloodgroup = result.getString(2);
            String email=result.getString(3);
            data d1=new data(name,date,bloodgroup,email);

            arrayList.add(d1);
        }
        return arrayList;
    }

    public ArrayList<data1> getAllData1() {
        ArrayList<data1> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("Select * from DonateBlood", null);

        while (result.moveToNext()) {
            String name = result.getString(0);
            String bloodgroup = result.getString(2);
            data1 d1=new data1(name,bloodgroup);

            arrayList.add(d1);
        }
        return arrayList;
    }

    public String validate1(String empid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select EmployeeId,Password from EmployeeDetails", null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(empid)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    public String EmployeeRegister(String username,String password,String Designation,String Branch){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("EmployeeId", username);
        cv.put("Password", password);
        cv.put("Designation", Designation);
        cv.put("Branch", Branch);

        long res = db.insert("EmployeeDetails", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Employee Successfully Registered";
    }

    public boolean checkempid(String empid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from EmployeeDetails where EmployeeId=?", new String[]{empid});

        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public Cursor getempinformation(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select EmployeeId,Designation,Branch from EmployeeDetails where EmployeeId=?",new String[]{username});
        if(cursor!=null){
            cursor.moveToNext();
        }
        return cursor;
    }

    public boolean UpdateEmp(String username,String Designation,String Branch){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("EmployeeId", username);
        cv.put("Designation", Designation);
        cv.put("Branch", Branch);
        db.update(  "EmployeeDetails",cv,"EmployeeId=?",new String[]{username});
        return true;
    }

    public boolean UpdateUser(String FirstName, String LastName, String FatherName, String Address, String PhoneNo, String Email, String Pincode, String City, String BloodType,String Gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FirstName", FirstName);
        cv.put("LastName", LastName);
        cv.put("FatherName", FatherName);
        cv.put("Address", Address);
        cv.put("PhoneNo", PhoneNo);
        cv.put("Email", Email);
        cv.put("Pincode", Pincode);
        cv.put("City", City);
        cv.put("BloodType", BloodType);
        cv.put("Gender", Gender);

        db.update("Register",cv,"Email=?",new String[]{Email});
        return true;

    }

}