package io.techleadacademy.stepDefs.dbSteps;

import io.techleadacademy.utils.ConfigReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JDBCTests {
    String url;
    String username;
    String password;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    @Before
    public void setUp(){
        //Database credentials
        url = "jdbc:postgresql://" + ConfigReader.readProperty("endpoint");
        username = ConfigReader.readProperty("db-username");
        password = ConfigReader.readProperty("db-password");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(){
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test01() {
        try {
            //Create a query
            String query = "SELECT * FROM users";
            //Create statement
            statement = connection.prepareStatement(query);
            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();
            //process the response (returned result from db)
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");
                System.out.println("Id: " + id + " | " + first + " " + last);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test02() {
        try {
            //Create a query
            String query = "SELECT * FROM users";
            //Create statement
            statement = connection.prepareStatement(query);
            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(metaData.getColumnCount());

            for (int i = 1; i <= metaData.getColumnCount(); i++){
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                int size = metaData.getColumnDisplaySize(i);
                System.out.println(columnName + " | " + columnType + " | " + size);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test03() {
        try {
            //Create a query
            String query = "SELECT * FROM users WHERE first_name=? AND last_name=?";
            //Create statement
            statement = connection.prepareStatement(query);
            statement.setString(1, "Kuba");
            statement.setString(2, "Zhaanbaev");
            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();
            //process the response (returned result from db)
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");
                System.out.println("Id: " + id + " | " + first + " " + last);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test04() {
        try {
            String query = "SELECT * FROM modules";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("module_id");
                String name = resultSet.getString("module_name");
                double order = resultSet.getDouble("module_order");
                System.out.println("ID: " + id + " | Name: " + name + " | " + "Order: " + order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test05() {
        try {
            String query = "SELECT * FROM modules " +
                    "WHERE video_link IS NOT NULL " +
                    "AND video_link <> ''";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("module_name");
                int order = resultSet.getInt("module_order");
                String link = resultSet.getString("video_link");
                System.out.println("Name: " + name + " | " + "Order: " + order + " | Video Link: " + link);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
