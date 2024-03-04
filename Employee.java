package org.example.banksystem.dao;

public class Employee {
    public static Integer ssn;
    private static String name;
    private static Integer phone;
    private static String address;

    public Employee() {
        ssn = 0;
        name = "";
        phone = 0;
        address = "";
    }

    public Employee(Integer ssn, String name, Integer phone, String address) {
        this.ssn = ssn;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
