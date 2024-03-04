package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewDashBoard extends JDialog {
    private JLabel welcomeToOurBankLabel;
    private JPanel NewDashBoard;
    private JButton signUpANewButton;
    private JButton addNewCustomerByButton;
    private JButton deleteCustomerByAdminsButton;
    private JButton listOfCustomersButton;
    private JButton updateUserSInfoButton;
    private JLabel chooseWhatDoYouLabel;
    private JButton addBankByAdminsButton;
    private JButton addBankBranchByButton;
    private JButton deleteBankBranchByButton;
    private JButton requestForLoanButton;
    private JButton updateBankInfoButton;

    public NewDashBoard(JFrame Parent) {
        super(Parent);
        setTitle("Dashboard");
        setContentPane(NewDashBoard);
        setMinimumSize(new Dimension(450, 473));
        setModal(true);
        setLocationRelativeTo(Parent);


        signUpANewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signup s = new signup(null);
                s.show();
            }
        });


        updateUserSInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateForm u = new UpdateForm(null);
                u.show();

            }
        });

        addNewCustomerByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddingCustomerForm a = new AddingCustomerForm(null);
                a.show();

            }
        });

        addBankByAdminsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBankForm add = new AddBankForm(null);
                add.show();
            }
        });
        addBankBranchByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBankBranchForm s = new AddBankBranchForm(null);
                s.show();

            }
        });

        deleteCustomerByAdminsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddingCustomerForm w = new AddingCustomerForm(null);
                w.show();
            }
        });

        deleteBankBranchByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBankBranchForm c = new AddBankBranchForm(null);
                c.show();

            }
        });

        deleteBankBranchByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBankBranchForm f = new AddBankBranchForm(null);
                f.show();

            }
        });

        requestForLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerForm v = new CustomerForm(null);
                v.show();

            }
        });

        updateBankInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBankForm m = new AddBankForm(null);
                m.show();
            }
        });
        //setVisible(true);
        listOfCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }

                String query = "SELECT * FROM newcustomer";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {


                    preparedStatement.executeQuery(query);


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


        });
        setVisible(true);

    }
}

