package org.example.banksystem.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateForm extends JDialog {
    private JTextField tfid;
    private JTextField tfnewname;
    private JTextField tfnewmail;
    private JPasswordField pfpassword;
    private JButton btnupdate;
    private JPanel updatepanel;
    private JButton DELETEButton;

    public UpdateForm(JFrame Parent) {
        super(Parent);
        setTitle("update your data");
        setContentPane(updatepanel);
        setMinimumSize(new Dimension(450, 473));
        setModal(true);
        setLocationRelativeTo(Parent);


        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws RuntimeException {
                Connection con = DBconnection.getConnection();
                if (con == null) {
                    return;
                }
                String query = "UPDATE newemployee SET name=? , mail=?, password=? WHERE ID=? ";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, tfnewname.getText());
                    preparedStatement.setString(2, tfnewmail.getText());
                    preparedStatement.setString(3, pfpassword.getText());
                    preparedStatement.setString(4, tfid.getText());
                    Integer RA = preparedStatement.executeUpdate();
                    if (RA == 0) {
                        try {
                            throw new SQLException("update failed");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null ,
                                "  User info  updated successfully" ,
                                "Done" ,
                                JOptionPane.OK_CANCEL_OPTION );
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        setVisible(true);

    }
}



