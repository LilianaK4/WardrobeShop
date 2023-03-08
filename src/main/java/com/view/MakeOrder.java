package com.view;

import com.accessories.*;
import com.operations.DatabaseOperations;
import com.order.Order;
import com.wardrobe_bases.DoubleWardrobe;
import com.wardrobe_bases.SingleWardrobe;
import com.wardrobe_bases.Wardrobe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOrder {

    private DatabaseOperations databaseOperations = DatabaseOperations.getInstance();
    static JFrame makeOrderFrame;
    private JTextField chooseBaseTextField;
    public JPanel makeOrderPanel;
    private JRadioButton singleWardrobeRadioButton;
    private JRadioButton doubleWardrobeRadioButton;
    private JRadioButton clothesRailRadioButton;
    private JRadioButton pullOutTrousersHangerRadioButton;
    private JRadioButton shoeShelfRadioButton;
    private JRadioButton additionalShelfRadioButton;
    private JRadioButton additionalDrawerRadioButton;
    private JRadioButton mirrorRadioButton;
    private JRadioButton meshBasketRadioButton;
    private JButton confirmButton;
    private JButton backButton;

    private Wardrobe wardrobe;
    private Order order;


    public MakeOrder(int id) {

        makeOrderFrame = new JFrame("Make an order");


        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (singleWardrobeRadioButton.isSelected() && doubleWardrobeRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Choose only one base");
                } else if (!singleWardrobeRadioButton.isSelected() && !doubleWardrobeRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Choose base");
                } else {
                    if(singleWardrobeRadioButton.isSelected()) {
                        wardrobe = new SingleWardrobe();
                    }
                    else {
                        wardrobe = new DoubleWardrobe();
                    }
                    if(clothesRailRadioButton.isSelected()) {
                        wardrobe = new ClothesRail(wardrobe);
                    }
                    if(additionalDrawerRadioButton.isSelected()) {
                        wardrobe = new Drawer(wardrobe);
                    }
                    if(meshBasketRadioButton.isSelected()) {
                        wardrobe = new MeshBasket(wardrobe);
                    }
                    if(mirrorRadioButton.isSelected()) {
                        wardrobe = new Mirror(wardrobe);
                    }
                    if(additionalShelfRadioButton.isSelected()) {
                        wardrobe = new Shelf(wardrobe);
                    }
                    if(shoeShelfRadioButton.isSelected()) {
                        wardrobe = new ShoeShelf(wardrobe);
                    }
                    if(pullOutTrousersHangerRadioButton.isSelected()) {
                        wardrobe = new TrouserHanger(wardrobe);
                    }
                    order = new Order(wardrobe);
                    if(databaseOperations.addOrderToDatabase(order)) {
                        String message = "Your order:\n\n" + wardrobe.description() + "\n\nhas been placed\n\nOrder amount: " + order.getOrderAmount() ;
                        JOptionPane.showMessageDialog(null, message);
                        openMenu(id);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
                        openMenu(id);
                    }
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMenu(id);
            }
        });
    }

    private void openMenu(int id) {
        Component comp = SwingUtilities.getRoot(makeOrderPanel);
        ((Window) comp).dispose();

        JFrame menuFrame = new JFrame("Menu");
        Menu form = new Menu(id);
        menuFrame.setContentPane(form.menuPanel);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setVisible(true);
    }
}
