package com.operations;

import com.connector.Connector;
import com.order.Order;
import com.user.IUser;
import com.user.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class DatabaseOperations implements IDatabaseOperations {

    private static DatabaseOperations instance = null;
    PreparedStatement st = null;
    ResultSet resultSet = null;
    Connection connection;
    Connector connector;

    User user;


    //SINGLETON
    private DatabaseOperations() {
        this.connector = new Connector();
        connection = connector.connection;
        this.user = new User();
    }

    public static DatabaseOperations getInstance() {
        if (instance == null) {
            instance = new DatabaseOperations();
        }
        return instance;
    }



    public boolean addUser(IUser user) {
        try {
            st = connection.prepareStatement("insert into Users values (?,?,?,?,?,?)");
            st.setString(1, null);
            st.setString(2, user.getName());
            st.setString(3, user.getSurname());
            st.setString(4, user.getLogin());
            st.setString(5, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
            st.setInt(6, user.getPhone());
            if(st.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public boolean checkIfUserExists(IUser user) {
        int count;
        count = 0;
        try {
            st = connection.prepareStatement("select  * from Users where login = ? and password = ?");
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            resultSet = st.executeQuery();

            //Checking if the user exists
            while (resultSet.next())
                count++;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (count == 0)
            return false;
        else
            return true;
    }


    public boolean logIn(String login, String password) {
        try {
            st = connection.prepareStatement("select * from Users where login = ?");
            st.setString(1, login);
            resultSet = st.executeQuery();
            if(resultSet.next()) {
                if(BCrypt.checkpw(password, resultSet.getString("password"))) {
                    this.user.setId(resultSet.getInt("idUser"));
                    return true;
                }
                else {
                    System.out.println("Incorrect password");
                    return false;
                }
            }
            else
                System.out.println("There is no user with matching login. Try again or sign up");
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getIdUser() {
        return this.user.getId();
    }

    public ResultSet getOrders() {
        try {
            st = connection.prepareStatement("select  * from Orders where idUser = ?");
            st.setInt(1, user.getId());
            resultSet = st.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean addOrderToDatabase(Order order) {
        try {

            st = connection.prepareStatement("insert into Orders values (?, ?, ?, ?, ?)");
            st.setString(1, null);
            st.setBigDecimal(2, BigDecimal.valueOf(order.getOrderAmount()));
            LocalDate local = LocalDate.now();
            st.setDate(3, Date.valueOf(local));
            st.setString(4, order.getDetails());
            st.setInt(5, user.getId());
            if(st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;

    }






}
