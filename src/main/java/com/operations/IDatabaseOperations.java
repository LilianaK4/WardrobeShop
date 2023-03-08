package com.operations;
import com.order.Order;
import com.user.IUser;

import java.sql.ResultSet;

public interface IDatabaseOperations {


    public boolean addUser(IUser user);
    public boolean checkIfUserExists(IUser user);
    public boolean logIn(String login, String password);

    public int getIdUser();
    public ResultSet getOrders();
    public boolean addOrderToDatabase(Order order);

}
