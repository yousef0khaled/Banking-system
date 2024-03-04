package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.banksystem.dao.Employee.ssn;

public class AddingCustomerForm extends JDialog{
    private JTextField tfssn;
    private JTextField tfname;
    private JTextField tfnumber;
    private JTextField tfaddress;
    private JButton btnaddcustomer;
    private JButton btncancel;
    private JPanel addcustomerpanel;
    private JButton DELETEButton;

    public AddingCustomerForm(JFrame Parent){
        super(Parent);
        setTitle("Add a Customer Form");
        setContentPane(addcustomerpanel);
        setMinimumSize(new Dimension(450,473));
        setModal(true);
        setLocationRelativeTo(Parent);

        btnaddcustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }
                String query = "insert into newcustomer ( name , phone , address) values ( ? , ? , ?) ";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {


                    preparedStatement.setString(1, tfname.getText());
                    preparedStatement.setString(2, tfnumber.getText());
                    preparedStatement.setString(3, tfaddress.getText());
                    preparedStatement.executeUpdate();
                    JOptionPane.showConfirmDialog(null ,
                            "  Customer added successfully" ,
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

        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return ;
                }


                String query = "DELETE FROM newcustomer WHERE name=? ";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                    preparedStatement.setString(1,tfname.getText());
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




