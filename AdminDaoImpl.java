package org.example.banksystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminDaoImpl implements AdminDao {
    public void AddBank() throws IOException {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the bank name: ");
            String name = input.next();
            System.out.print("Enter the bank code: ");
            String code = input.next();
            System.out.print("Enter the bank address: ");
            String address = input.next();
            String query = "insert into Bank(name , code , address) values (? , ? , ?) ";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, code);
                preparedStatement.setString(3, address);
                preparedStatement.executeUpdate();
                System.out.println("You added a bank successfully!");
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
    public void AddBankBranch() throws IOException {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }
        Scanner input = new Scanner(System.in);
        try {
            input = new Scanner(System.in);

//            System.out.print("Enter the bank code : ");
//            Integer code = input.next();
            System.out.print("Enter the bank address : ");
            String address = input.next();
            System.out.print("Enter the bank branch number: ");
            String Branch_no = input.next();
            String query = "insert into bankbranch( address, Branch_no) values ( ? ,?) ";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {


               // preparedStatement.setInt(2, code);
                preparedStatement.setString(1, address);
                preparedStatement.setString(2, Branch_no);
                preparedStatement.executeUpdate();
                System.out.println("You added a bank branch successfully!");
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


}
