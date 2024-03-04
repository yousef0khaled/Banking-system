package org.example.banksystem.dao;

public class Admin {
    private String name;
    private Integer code;
    private String address;
    private Integer Branch_no;
    public Admin() {
        name = " ";
        code = 0;
        address = " ";
        Branch_no= 0;
    }
    public Admin(String name,Integer code, String address,Integer branchnumber) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.Branch_no = branchnumber;
    }
    public String getName() {
        return name;
    }
    public Integer getCode() {
        return code;
    }
    public String getAddress() {
        return address;
    }
    public Integer getBranchno() {
        return Branch_no;
    }
    public String toString() {
        return "Name: " + name + "\ncode: " + code + "\naddress :" + address;
    }


}
