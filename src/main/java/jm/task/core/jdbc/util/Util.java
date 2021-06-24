package jm.task.core.jdbc.util;

import org.hibernate.Hibernate;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "jekasql", "12345");
    }

    public void hiber() {

    }
}
