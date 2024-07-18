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
            //Create a query
            String query = "SELECT * FROM modules";
            //Create statement
            statement = connection.prepareStatement(query);
            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();
            //process the response (returned result from db)
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                    int moduleId = resultSet.getInt("module_id");
                    String moduleName = resultSet.getString("module_name");
                    int moduleOrder = resultSet.getInt("module_order");
                    String createTime = resultSet.getString("create_time");
                    String updateTime = resultSet.getString("update_time");
                    System.out.println("Module id: " + moduleId + " | " + "Module name: " + moduleName +
                            " | " +  "Module order: " + moduleOrder +  " | " +  "Create Time : "
                            + createTime +  " | " +  "Update time: " + updateTime);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test05() {
        try {
            //Create a query
            String query = "SELECT module_name, video_link FROM modules WHERE video_link IS NOT NULL AND video_link <> ''";

            //Create statement
            statement = connection.prepareStatement(query);

            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();
            //process the response (returned result from db)
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String moduleName = resultSet.getString("module_name");
                String videoLink = resultSet.getString("video_link");
                System.out.println("Module name: " + moduleName +
                        " | " + "Video link: " + videoLink);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test06() {
        try {
            //Create a query
            String query = "SELECT task_name FROM tasks WHERE module_name = ?";

            //Create statement
            statement = connection.prepareStatement(query);
            statement.setString(1, "Variables");
            //Execute the query byt sending the request to the db
            resultSet = statement.executeQuery();
            //process the response (returned result from db)
            while (resultSet.next()) {
                String taskName = resultSet.getString("task_name");
                System.out.println("Task name: " + taskName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Class Task:
    //
    //- Add a new task in tasks table
    //- Verify it was created by fetching data and printing out following:
    //	- id
    //	- name
    //	- instruction
    //- Update the instruction of the task
    //- Verify it was updated but retrieving the data and printing out id, name, instruction details
    //- Delete the task
    //- Verify it was deleted
    @Test
    public void test07() {
        try {
            //Create a query
            String insertQuery = "INSERT INTO tasks(task_name, task_id, instruction, code, module_name) VALUES (?, ?, ?, ?, ?);";
            //Create statement
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, "Method Overloading");
            statement.setInt(2, 515);
            statement.setString(3, "Overload the below method");
            statement.setString(4, "public class Test{}");
            statement.setString(5, "Polymorphism");
            int insertUpdate  = statement.executeUpdate();

            String selectQuery = "SELECT * FROM tasks WHERE task_id = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1,515);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String taskName = resultSet.getString("task_name");
                int id = resultSet.getInt("task_id");
                String instruction = resultSet.getString("instruction");
                System.out.println("Task name: " + taskName + " | ID: " + id + " | Instruction: " + instruction);

            }

            String updateQuery = "UPDATE tasks SET instruction = ? " +
                    "WHERE task_id = ?;";
            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, "Print in reverse order");
            statement.setInt(2, 515);
            int update = statement.executeUpdate();

            selectQuery = "SELECT * FROM tasks WHERE task_id = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1,515);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String taskName = resultSet.getString("task_name");
                int id = resultSet.getInt("task_id");
                String instruction = resultSet.getString("instruction");
                System.out.println("Task name: " + taskName + " | ID: " + id + " | Instruction: " + instruction);

            }

            String deleteQuery = "DELETE FROM tasks WHERE task_id = ?";
            statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, 515);
            int deleteUpdate = statement.executeUpdate();


            selectQuery = "SELECT COUNT(*) FROM tasks WHERE task_id = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1, 515);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    System.out.println("Task was successfully deleted.");
                } else {
                    System.out.println("Task was not deleted.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
