package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerForm extends JDialog {
    private JLabel helloCustomerLabel;
    private JLabel TypesOfLoansLabel;
    private JLabel industrialLoanCommercialLoanLabel;
    private JTextField enterAmountOfLoanTextField;
    private JTextField enterTypeOfLoanTextField;
    private JButton DONEButton;
    private JLabel enterTypeOfLoanLabel;
    private JLabel enterAmountOfLoanLabel;
    private JPanel CustomerFormPanel;
    public CustomerForm(JFrame Parent){
        super(Parent);
        setTitle("Hello customer");
        setContentPane(CustomerFormPanel);
        setMinimumSize(new Dimension(450,473));
        setModal(true);
        setLocationRelativeTo(Parent);

        DONEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }

                    String query = "INSERT INTO loan( loan_amnt , loan_type) VALUES(?,?)";
                    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                        preparedStatement.setString(1, enterAmountOfLoanTextField.getText());
                        preparedStatement.setString(2, enterTypeOfLoanTextField.getText());



                        preparedStatement.executeUpdate();

                        JOptionPane.showConfirmDialog(null ,
                                "  Loan accepted successfully" ,
                                "Done" ,
                                JOptionPane.OK_CANCEL_OPTION );
                    } catch (SQLException se) {
                        se.printStackTrace();

                    } finally {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }


                }

            }
        );
            setVisible(true);
        }
    }







