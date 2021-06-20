package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        try (Connection connection = Util.connect()) {
            StringBuilder QUERY = new StringBuilder();
            QUERY.append("CREATE TABLE IF NOT EXISTS Users(");
            QUERY.append("id MEDIUM NOT NULL AUTO_INCREMENT PRIMARY KEY, ");
            QUERY.append("name text NOT NULL, ");
            QUERY.append("lastName text NOT NULL, ");
            QUERY.append("age int NOT NULL)");
            PreparedStatement statement = connection.prepareStatement(QUERY.toString());
            statement.executeQuery();
        } catch (SQLException e) {

        }
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
