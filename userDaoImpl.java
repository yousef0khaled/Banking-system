package org.example.banksystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



 public class userDaoImpl implements userdao {
   @Override
    public void signup() throws IOException {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }

        Scanner input = new Scanner(System.in);
        try {

            System.out.println("please enter your name: ");
            String Name = input.next();
            System.out.println("please enter your mail: ");
            String mail = input.next();
            System.out.println("please enter your password: ");
            String password = input.next();
            String query = "insert into employee(Name , mail , password) values (? , ? , ?) ";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, Name);
                preparedStatement.setString(2, mail);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();

                System.out.println("User signed up successfully!");


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
    public void update() {
        Connection con = DBconnection.getConnection();
        if (con == null) {        return;
        }
        Scanner input = new Scanner(System.in);    try {
            System.out.println(" please enter your id to update data ");
            String ID = input.next();
            System.out.println(" please enter your new password: ");
            String password1 = input.next();
            System.out.println("enter your new name and mail");
            String name1 =input.next();
            String mail1 = input.next();
            String query = "UPDATE employee SET  password=?, name=?, mail=? WHERE ID=?;";
            try  (PreparedStatement preparedStatement =con.prepareStatement( query )){
                preparedStatement.setString(2,name1);
                preparedStatement.setString(3,mail1);
                preparedStatement.setString(1,password1);
                preparedStatement.setString(4,ID);
                Integer RA;
                RA = preparedStatement.executeUpdate();
                if (RA == 0){
                    throw new SQLException("update failed");
                }
                else{
                    System.out.println("User info updated successfully!");
                }
            }

        }
        catch (SQLException se) {
            se.printStackTrace();
        }    finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}








