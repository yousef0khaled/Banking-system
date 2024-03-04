package org.example.banksystem.dao;

import java.io.IOException;
import java.util.List;

public interface EmployeeDao {
    void signupcustomer() throws IOException;
    public List<Employee> findAll();
}
