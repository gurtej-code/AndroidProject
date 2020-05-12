package com.example.bloodbankproject.Model;

public class data {
    String name;
    String date;
    String bloodgroup;
    String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public data(String name,String date,String bloodgroup,String Email){
        this.name=name;
        this.date=date;
        this.bloodgroup=bloodgroup;
        this.Email=Email;
    }

    public data(){}



}