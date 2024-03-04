package org.example.banksystem.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




    public class EmployeeDaoImpl implements EmployeeDao {
        private Employee employee;
        private Object employeeDao;
        @Override
        public void signupcustomer() throws IOException {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return;
            }

            Scanner input = new Scanner(System.in);
            try {

                System.out.print("Enter your SSN: ");
                String ssn = input.next();
                System.out.print("Enter your name: ");
                String name = input.next();
                System.out.print("Enter your phone number: ");
                String phone = input.next();
                System.out.print("Enter your address: ");
                String address = input.next();

                String query = "insert into customer (ssn , name , phone , address) values (? , ? , ? , ?) ";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                    preparedStatement.setString(1, ssn);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, phone);
                    preparedStatement.setString(4, address);

                    preparedStatement.executeUpdate();

                    System.out.println("You added as a customer successfully!!");


                } catch (SQLException se) {
                    se.printStackTrace();

                } finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
        /*finally {
            input.close();
        }*/
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<Employee> findAll() {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return null;
            }
                List<Employee> employees = new LinkedList<>();
             String query ="SELECT * FROM customer;";
            try (PreparedStatement preparedStatement=con.prepareStatement(query)){
                ResultSet resultSet=preparedStatement.executeQuery();

                while(resultSet.next()){
                     employees.add(employee);
                }
                }catch (SQLException se){
                 se.printStackTrace();
                } finally{
                try{
                     con.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
             }
             return employees;
 }

        }



