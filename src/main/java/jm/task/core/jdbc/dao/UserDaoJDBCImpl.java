package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import java.util.LinkedList;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        try (Connection connection = Util.connect()) {
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE TABLE IF NOT EXISTS Users(");
            sql.append("id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ");
            sql.append("name text NOT NULL, ");
            sql.append("lastName text NOT NULL, ");
            sql.append("age INT NOT NULL);");
            Statement statement = connection.createStatement();
            System.out.println(statement.executeUpdate(sql.toString()));
        } catch (SQLException e) {
            throw e;
        }

    }

    public void dropUsersTable() throws SQLException {
        try (Connection connection = Util.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Users;");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try (PreparedStatement preparedStatement = Util.connect().prepareStatement("INSERT INTO  Users" +
                "(name, lastName, age) VALUES (?, ?, ?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, (int) age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void removeUserById(long id) throws SQLException {
        try (Statement statement =  Util.connect().createStatement()) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM Users WHERE id = ");
            sql.append(Long.toString(id));
            sql.append(";");
            statement.executeUpdate(sql.toString());
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = null;
        try (Statement statement =  Util.connect().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *  FROM Users;");
            List<User> userTmp = new LinkedList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                userTmp.add(user);
                users = userTmp;
            }
        }
        catch (SQLException e) {
            throw e;
        }
        if (users == null) {
            return new LinkedList<User>();
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        try (Statement statement = Util.connect().createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE Users;");
        } catch (SQLException e) {
            throw e;
        }
    }
}
