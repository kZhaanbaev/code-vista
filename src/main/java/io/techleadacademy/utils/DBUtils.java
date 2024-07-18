package io.techleadacademy.utils;

import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private TestContext testContext;

    public DBUtils(TestContext testContext){
        this.testContext = testContext;
    }


    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().resultSet = testContext.DB().preparedStatement.executeQuery();
            while (testContext.DB().resultSet.next()){
                User user = new User(
                        testContext.DB().resultSet.getInt("user_id"),
                        testContext.DB().resultSet.getString("first_name"),
                        testContext.DB().resultSet.getString("last_name"),
                        testContext.DB().resultSet.getString("email"),
                        testContext.DB().resultSet.getString("password"),
                        testContext.DB().resultSet.getString("role")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public List<User> getAllUsers(int count) {
        String query = "SELECT * FROM users LIMIT " + count;
        List<User> userList = new ArrayList<>();

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().resultSet = testContext.DB().preparedStatement.executeQuery();
            while (testContext.DB().resultSet.next()){
                User user = new User(
                        testContext.DB().resultSet.getInt("user_id"),
                        testContext.DB().resultSet.getString("first_name"),
                        testContext.DB().resultSet.getString("last_name"),
                        testContext.DB().resultSet.getString("email"),
                        testContext.DB().resultSet.getString("password"),
                        testContext.DB().resultSet.getString("role")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

}
