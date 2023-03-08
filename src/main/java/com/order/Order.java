package com.order;

import com.wardrobe_bases.Wardrobe;

public class Order implements IOrder {
    int orderID;
    float orderAmount;
    String details;


    public Order(Wardrobe wardrobe) {
        this.orderAmount = wardrobe.price();
        this.details = wardrobe.description();
    }


    public Order(float orderAmount, String details) {
        this.orderAmount = orderAmount;
        this.details = details;
    }


    @Override
    public int getOrderID() {
        return orderID;
    }

    @Override
    public float getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String getDetails() {
        return details;
    }


}
