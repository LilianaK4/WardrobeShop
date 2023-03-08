package com.view;


import com.operations.DatabaseOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogIn {

    public static LogIn form;
    static JFrame logInFrame;
    private JLabel signInTextField;
    private JLabel loginTextField;
    private JTextField loginField;
    private JLabel pinTextField;
    private JButton logInButton;
    private JPasswordField passwField;
    public JPanel logInPanel;
    private JButton registerButton;
    private JLabel ifTextField;

    DatabaseOperations databaseOperations = DatabaseOperations.getInstance();

    private void clearFields() {
        loginField.setText("");
        passwField.setText("");
    }


    public LogIn() {

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().isEmpty() || passwField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all required fields");
                } else {
                    String login = loginField.getText();
                    String passw = passwField.getText();
                    if (databaseOperations.logIn(login, passw)) {
                        clearFields();
                        JOptionPane.showMessageDialog(null, "Logged in successfully");

                        Component comp = SwingUtilities.getRoot(logInPanel);
                        ((Window) comp).dispose();

                        JFrame menuFrame = new JFrame("Menu");
                        Menu form2 = new Menu(databaseOperations.getIdUser());
                        menuFrame.setContentPane(form2.menuPanel);
                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.pack();
                        menuFrame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong login or password code\nor customer does not exist in customers database");
                    }
                }
            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInFrame.dispose();
                JFrame registerFrame = new JFrame("Register");
                Register form1 = new Register();
                registerFrame.setContentPane(form1.registerPanel);
                registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registerFrame.pack();
                registerFrame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        logInFrame = new JFrame("Log In");
        form = new LogIn();
        logInFrame.setContentPane(form.logInPanel);
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.pack();
        logInFrame.setVisible(true);
    }
}
