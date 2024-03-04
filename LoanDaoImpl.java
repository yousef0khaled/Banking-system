package org.example.banksystem.dao;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;

public class LoanDaoImpl implements LoanDao {
    public void addloan() throws IOException {
        Connection con = DBconnection.getConnection();
        Scanner input = new Scanner(System.in);
        Integer check;
        try {
            System.out.print("Enter your type: ");
            String loan_type = input.next();
            System.out.print("Enter amount: ");
            Integer amount = Integer.valueOf(input.next());
            Integer loan_amnt=null;
            if (amount > 5000 && amount < 500001) {
                loan_amnt = amount;
                System.out.print("Loan Accepted:) ");
            } else {
                System.out.print("Loan Rejected ");
            }

            String query = "INSERT INTO loan(loan_type,loan_amnt) VALUES(?,?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, loan_type);
                preparedStatement.setString(2, String.valueOf(loan_amnt));

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
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}