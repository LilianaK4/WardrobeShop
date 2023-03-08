package com.view;

import com.operations.DatabaseOperations;
import com.proxy.UserProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends Component {
    private static Register form;
    private JTextField registerTextField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel surnameTextField;
    private JTextField surnameField;
    private JTextField addressField;
    private JLabel phoneTextField;
    private JTextField phoneField;
    private JButton submitButton;
    private JLabel loginTextField;
    private JTextField loginField;
    private JPasswordField pinField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    public JPanel registerPanel;
    private JLabel ifYouAlreadyHaveLabel;
    private JButton signInButton;
    private JSeparator separator;

    private UserProxy userProxy = new UserProxy();

    DatabaseOperations databaseOperations = DatabaseOperations.getInstance();


    private void clearFields() {
        nameField.setText("");
        surnameField.setText("");
        phoneField.setText("");
        loginField.setText("");
        passwordField.setText("");
    }


    public Register() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().isEmpty() || passwordField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all required fields");
                } else {
                    String login = loginField.getText();
                    String password = passwordField.getText();
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    int phone = Integer.parseInt(phoneField.getText());

                    if (login != "login" && databaseOperations.addUser(userProxy.newUser(name, surname,login, password,phone))) {
                        clearFields();
                        JOptionPane.showMessageDialog(null, "Account added");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }

                }
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = SwingUtilities.getRoot(registerPanel);
                ((Window) comp).dispose();

                JFrame logInFrame = new JFrame("Log In");
                LogIn form = new LogIn();
                logInFrame.setContentPane(form.logInPanel);
                logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                logInFrame.pack();
                logInFrame.setVisible(true);
            }
        });


    }

}
