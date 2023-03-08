package com.view;

import com.operations.DatabaseOperations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CheckOrders {
    public JPanel checkOrdersPanel;

    DatabaseOperations databaseOperations = DatabaseOperations.getInstance();
    private JTextField yourOrdersTextField;
    private JButton anotherOperationButton;
    private JButton signOutButton;
    private JTable ordersTable;
    private int id;


    public void printOrders(int id) {
        try {
            ResultSet resultSet = databaseOperations.getOrders();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
            int columns = rsmd.getColumnCount();
            String[] colName = new String[columns];
            for (int i = 0; i < columns; i++) {
                colName[i] = rsmd.getColumnName(i+1);
            }
            model.setColumnIdentifiers(colName);
            ordersTable.setModel(model);


            String[] row1 = {"Order ID", "Order amount", "Date of order", "Details"};
            model.addRow(row1);

            while(resultSet.next()) {
                String orderId, amount, date, details;
                orderId = resultSet.getString(1);
                amount = resultSet.getString(2);
                date = resultSet.getString(3);
                details = resultSet.getString(4);
                String[] row = {orderId, amount, date, details};
                model.addRow(row);
            }
            ordersTable = new JTable(model);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




    public CheckOrders(int id) {

        this.id = id;
        printOrders(id);


        anotherOperationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = SwingUtilities.getRoot(checkOrdersPanel);
                ((Window) comp).dispose();

                JFrame menuFrame = new JFrame("Menu");
                Menu form = new Menu(id);
                menuFrame.setContentPane(form.menuPanel);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.pack();
                menuFrame.setVisible(true);
            }
        });


        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = SwingUtilities.getRoot(checkOrdersPanel);
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
