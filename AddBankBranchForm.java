package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBankBranchForm extends JDialog {
    private JTextField tfbranchno;
    private JTextField tfaddress;
    private JButton btnadd;
    private JPanel addbankbranchpanel;
    private JButton deleteButton;

    public AddBankBranchForm(JFrame Parent) {
        super(Parent);
        setTitle("Add Bank");
        setContentPane(addbankbranchpanel);
        setMinimumSize(new Dimension(450, 473));
        setModal(true);
        setLocationRelativeTo(Parent);


        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }
                String query = "insert into newbankb(branchnumber , Address) values (? , ?) ";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                    preparedStatement.setString(1, tfbranchno.getText());
                    preparedStatement.setString(2, tfaddress.getText());
                    preparedStatement.executeUpdate();
                    JOptionPane.showConfirmDialog(null ,
                            "Branch added successfully" ,
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
        //setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }


                String query = "DELETE FROM newbankb WHERE branchnumber=? ";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                    preparedStatement.setString(1, tfbranchno.getText());
                    preparedStatement.executeUpdate();
                    JOptionPane.showConfirmDialog(null ,
                            "deletion done successfully" ,
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
