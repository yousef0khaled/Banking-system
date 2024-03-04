package org.example.banksystem.dao;



public class user {
    public   static  Integer ID;
    public static String Name;
    public static String mail;
    public static String password;

    public user() {

        Name = "";
        mail = "";
        password = "";

    }

    public  String getName() {
        return Name;
    }

    public  String getMail() {
        return mail;
    }

    public  String getPassword() {
        return password;
    }

    public String toString() {
        return "Name: " + Name + "\nmail: " + mail + "\npassword :" + password;
    }


}


