package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "feniks");
    }
}
