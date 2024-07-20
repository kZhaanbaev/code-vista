package io.techleadacademy.utils;

import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.User;
import io.techleadacademy.pojo.Module;
import org.junit.Assert;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
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

    public List<Module> getAllModules(int count) {
        String query = "SELECT * FROM modules LIMIT " + count;
        List<Module> moduleList = new ArrayList<>();

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().resultSet = testContext.DB().preparedStatement.executeQuery();
            while (testContext.DB().resultSet.next()){
                Module module = new Module(
                        testContext.DB().resultSet.getInt("module_id"),
                        testContext.DB().resultSet.getString("module_name"),
                        testContext.DB().resultSet.getDouble("module_order"),
                        testContext.DB().resultSet.getString("video_link")
                );
                moduleList.add(module);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return moduleList;
    }

    public void createNewUser(User user) {
        String query = "INSERT INTO users(user_id, first_name, last_name, email, password, role) " +
                "VALUES(?, ?, ?, ?, ?, ?);";

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().preparedStatement.setInt(1, user.getUser_id());
            testContext.DB().preparedStatement.setString(2, user.getFirst_name());
            testContext.DB().preparedStatement.setString(3, user.getLast_name());
            testContext.DB().preparedStatement.setString(4, user.getEmail());
            testContext.DB().preparedStatement.setString(5, user.getPassword());
            testContext.DB().preparedStatement.setString(6, user.getRole());

            testContext.DB().preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Object> getRowData(String column, String value, String table) {
        String query = "SELECT * FROM " + table + " WHERE " + column + " = ?";
        List<Object> list = new ArrayList<>();

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            DatabaseMetaData metaData = testContext.DB().connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, table, column);
            if (columns.next()) {
                String columnType = columns.getString("TYPE_NAME");
                switch (columnType.toLowerCase()) {
                    case "int4":
                    case "int8":
                    case "integer":
                        testContext.DB().preparedStatement.setInt(1, Integer.parseInt(value));
                        break;
                    case "float8":
                        testContext.DB().preparedStatement.setDouble(1, Double.parseDouble(value));
                        break;
                    case "text":
                    default:
                        testContext.DB().preparedStatement.setString(1, value);
                        break;
                }
            }

            testContext.DB().resultSet = testContext.DB().preparedStatement.executeQuery();

            while (testContext.DB().resultSet.next()) {
                switch (table) {
                    case "users":
                        User user = new User(
                                testContext.DB().resultSet.getInt("user_id"),
                                testContext.DB().resultSet.getString("first_name"),
                                testContext.DB().resultSet.getString("last_name"),
                                testContext.DB().resultSet.getString("email"),
                                testContext.DB().resultSet.getString("password"),
                                testContext.DB().resultSet.getString("role")
                        );
                        list.add(user);
                        break;
                    case "modules":
                        Module module = new Module(
                                testContext.DB().resultSet.getInt("module_id"),
                                testContext.DB().resultSet.getString("module_name"),
                                testContext.DB().resultSet.getDouble("module_order"),
                                testContext.DB().resultSet.getString("video_link")
                        );
                        list.add(module);
                        break;
                    default:
                        Assert.fail("Invalid table name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public boolean updateModuleDataById(String column, String columnValue, int moduleId) {
        int count = 0;
        String query3 = "UPDATE modules " +
                "SET " + column + " = '" + Double.parseDouble(columnValue) + "' " +
                "WHERE module_id=?";
        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query3);
            testContext.DB().preparedStatement.setInt(1, moduleId);

            count = testContext.DB().preparedStatement.executeUpdate();

                System.out.println("Existing data was successfully updated in DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count > 0;
    }

    public boolean deleteModule(int moduleId) {
        try {
            String query = "DELETE FROM modules " +
                    "WHERE module_id=?";
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().preparedStatement.setInt(1, moduleId);

            if (testContext.DB().preparedStatement.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void createNewModule(Module module) {
        String query = "INSERT INTO modules(module_id, module_name, module_order, video_link) " +
                "VALUES(?, ?, ?, ?);";

        try {
            testContext.DB().preparedStatement = testContext.DB().connection.prepareStatement(query);
            testContext.DB().preparedStatement.setInt(1, module.getModule_id());
            testContext.DB().preparedStatement.setString(2, module.getModule_name());
            testContext.DB().preparedStatement.setDouble(3, module.getModule_order());
            testContext.DB().preparedStatement.setString(4, module.getVideo_link());
            testContext.DB().preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
