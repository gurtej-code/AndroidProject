package com.example.bloodbankproject.Model;

public class data1 {
    String Email;
    String Bloodgroup;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getBloodgroup() {
        return Bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        Bloodgroup = bloodgroup;
    }

    public data1(String Email,String bloodgroup){
        this.Bloodgroup=bloodgroup;
        this.Email=Email;
    }

    public data1(){}
}
