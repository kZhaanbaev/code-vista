package io.techleadacademy.core;

import io.techleadacademy.utils.ConfigReader;
import org.junit.Before;

import java.sql.*;

public class DBConnection {

    public static Connection connectToDB(){
        String url;
        String username;
        String password;

        Connection connection = null;
        //Database credentials
        url = "jdbc:postgresql://" + ConfigReader.readProperty("endpoint");
        username = ConfigReader.readProperty("db-username");
        password = ConfigReader.readProperty("db-password");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
