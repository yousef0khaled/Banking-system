package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBankForm extends JDialog{
    private JTextField nameTextField;
    private JTextField codeTextField;
    private JTextField addressTextField;
    private JButton ADDButton;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JPanel addbankpanel;
    private JButton updateButton;
    private JLabel codeLabel;

    public AddBankForm(JFrame Parent) {
    super(Parent);
    setTitle("Add Bank");
    setContentPane(addbankpanel);
    setMinimumSize(new Dimension(450,473));
    setModal(true);
    setLocationRelativeTo(Parent);

    ADDButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return;
            }
            String query = "insert into newbank (name , code , address) values (? , ? , ?) ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, nameTextField.getText());
                preparedStatement.setString(2, codeTextField.getText());
                preparedStatement.setString(3, addressTextField.getText());
                preparedStatement.executeUpdate();
                JOptionPane.showConfirmDialog(null ,
                        "Bank added  successfully" ,
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
       // setVisible(true);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }
                String query = "UPDATE newbank SET  name=? address=? WHERE code=? ";

                try  (PreparedStatement preparedStatement =con.prepareStatement( query )){
                    preparedStatement.setString(1, nameTextField.getText());
                    preparedStatement.setString(2, addressTextField.getText());
                   preparedStatement.setString(3, codeTextField.getText());

                     preparedStatement.executeUpdate();


                        JOptionPane.showConfirmDialog(null ,
                                "  Bank info  updated successfully" ,
                                "Done" ,
                                JOptionPane.OK_CANCEL_OPTION );


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        setVisible(true);
    }

}






