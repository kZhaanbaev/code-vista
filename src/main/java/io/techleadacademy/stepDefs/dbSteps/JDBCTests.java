package io.techleadacademy.stepDefs.dbSteps;

import io.techleadacademy.utils.ConfigReader;
import org.junit.After;
import org.junit.Assert;
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

    //HOMEWORK
    @Test
    public void test06() {
        try {
            //Create a query
            String query = "SELECT * FROM tasks WHERE module_name=?";
            //Create statement
            statement = connection.prepareStatement(query);
            statement.setString(1, "2D Arrays");
            resultSet = statement.executeQuery();

            //process the response (returned result from db)
            while (resultSet.next()) {
                String task = resultSet.getString("task_name");
                String module = resultSet.getString("module_name");
                System.out.println("Task: " + task + " | Module: " + module);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Adding new data to DB
    @Test
    public void test07() {
        try {
            //Create a query
            String query = "INSERT INTO modules(module_id, module_name, module_order) " +
                    "VALUES(?, ?, ?);";
            //Create statement
            statement = connection.prepareStatement(query);
            statement.setInt(1, 335);
            statement.setString(2, "4D Arrays");
            statement.setDouble(3, 1);
            int count = statement.executeUpdate();

            if (count > 0)
                System.out.println("New data was successfully added to DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adding task data to DB
    @Test
    public void test08() {
        try {
            //Create a query
            String query = "INSERT INTO tasks(task_id, task_name, instruction, module_name, task_order, code) " +
                    "VALUES(?, ?, ?, ?, ?, ?);";
            //Create statement
            statement = connection.prepareStatement(query);
            statement.setInt(1, 371);
            statement.setString(2, "Task - Kuba");
            statement.setString(6, "code");
            statement.setString(3, "Test instruction");
            statement.setString(4, "4D Arrays");
            statement.setDouble(5, 1);

            int count = statement.executeUpdate();

            if (count > 0)
                System.out.println("New data was successfully added to DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Task to create-update-delete a Task
    @Test
    public void test09() {
        try {
            int id = 380;
            //1. Add new Task
            String query = "INSERT INTO tasks(task_id, task_name, instruction, module_name, task_order, code) " +
                    "VALUES(?, ?, ?, ?, ?, ?);";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, "Task - Kuba");
            statement.setString(6, "code");
            statement.setString(3, "Test instruction");
            statement.setString(4, "4D Arrays");
            statement.setDouble(5, 1);

            int count = statement.executeUpdate();
            if (count > 0)
                System.out.println("New data was successfully added to DB");

            //2. retrieve newly created Task data with id, or name
            // print out id, name, instruction
            String query2 = "SELECT * from tasks WHERE task_id=?";
            statement = connection.prepareStatement(query2);
            statement.setInt(1, id);

            ResultSet resultSet1 = statement.executeQuery();
            while (resultSet1.next()){
                System.out.print(resultSet1.getInt("task_id") + " | ");
                System.out.print(resultSet1.getString("task_name") + " | ");
                System.out.println(resultSet1.getString("instruction"));
            }

            //3.Update newly created Task's name
            String query3 = "UPDATE tasks " +
                    "SET instruction = 'Updated instruction' " +
                    "WHERE task_id=?";
            statement = connection.prepareStatement(query3);
            statement.setInt(1, id);

            int count2 = statement.executeUpdate();
            if (count2 > 0)
                System.out.println("Existing data was successfully updated in DB");

            //4. retrieve newly updated Task data with id, or name
            // print out id, name, instruction
            String query4 = "SELECT * from tasks WHERE task_id=?";
            statement = connection.prepareStatement(query4);
            statement.setInt(1, id);

            ResultSet resultSet2 = statement.executeQuery();
            while (resultSet2.next()){
                System.out.print(resultSet2.getInt("task_id") + " | ");
                System.out.print(resultSet2.getString("task_name") + " | ");
                System.out.println(resultSet2.getString("instruction"));
            }

            //5. Delete newly created Task using id
            String query5 = "DELETE FROM tasks " +
                    "WHERE task_id=?";
            statement = connection.prepareStatement(query5);
            statement.setInt(1, id);

            if (statement.executeUpdate() > 0)
                System.out.println("Existing data was successfully Deleted");

            //6.Try to fetch Task using id, verify it fails
            String query6 = "SELECT * from tasks WHERE task_id=?";
            statement = connection.prepareStatement(query6);
            statement.setInt(1, id);

            ResultSet resultSet3 = statement.executeQuery();
            if (resultSet3.next()){
                Assert.fail("Deleted record was found in DB");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
