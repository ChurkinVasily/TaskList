package ru.churkin.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private Connection connection = null;

    public Connection getConnection(String url, String name, String pass) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(url, name, pass);
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
