package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signup extends JDialog {
    private JPanel signup;
    private JLabel signUpLabel;
    private JTextField enterYourNameTextField;
    private JTextField enterYourEmailTextField;
    private JButton signUpButton;
    private JLabel enterYourNameLabel;
    private JLabel enterYourEmailLabel;
    private JLabel enterYourPasswordLabel;
    private JPasswordField enterYourPasswordPasswordField;

    public signup(JFrame Parent){
        super(Parent);
        setTitle("Sign up Form");
        setContentPane(signup);
        setLocationRelativeTo(Parent);
        setMinimumSize(new Dimension(450 , 474));
        setModal(true);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws RuntimeException {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }


                String query = "insert into newemployee(Name , mail , password) values (? , ? , ?) ";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                    preparedStatement.setString(1, enterYourNameTextField.getText());
                    preparedStatement.setString(2, enterYourEmailTextField.getText());
                    preparedStatement.setString(3, enterYourPasswordPasswordField.getText());
                    preparedStatement.executeUpdate();

                    JOptionPane.showConfirmDialog(null ,
                            "  Signed up successfully" ,
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
