package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public JPanel menuPanel;

    private static Menu form;
    static JFrame menuFrame;
    private JButton checkOrdersButton;
    private JButton makeOrderButton;
    private JButton checkBalanceButton;
    private JButton signOutButton;




    public Menu(int id) {
        menuFrame = new JFrame("Menu");



        checkOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Component comp = SwingUtilities.getRoot(menuPanel);
                ((Window) comp).dispose();

                JFrame checkOrdersFrame = new JFrame("CheckOrders");
                CheckOrders form3 = new CheckOrders(id);
                checkOrdersFrame.setContentPane(form3.checkOrdersPanel);
                checkOrdersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                checkOrdersFrame.pack();
                checkOrdersFrame.setVisible(true);


            }
        });


        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Component comp = SwingUtilities.getRoot(menuPanel);
                ((Window) comp).dispose();

                JFrame depositFrame = new JFrame("Make order");

                MakeOrder form4 = new MakeOrder(id);
                depositFrame.setContentPane(form4.makeOrderPanel);
                depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                depositFrame.pack();
                depositFrame.setVisible(true);


            }
        });



        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = SwingUtilities.getRoot(menuPanel);
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
