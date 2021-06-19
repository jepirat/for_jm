package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public void connect() {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/test"
                             , "root"
                             , "feniks")) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }// реализуйте настройку соеденения с БД
}
