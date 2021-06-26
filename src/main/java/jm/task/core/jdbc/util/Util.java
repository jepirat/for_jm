package jm.task.core.jdbc.util;

import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.Hibernate;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.hibernate.service.ServiceRegistry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static ServiceRegistry serviceRegistry;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "jekasql", "12345");
    }

    public static Session getConnect()  {
        return new SessionFactory().getSession("/home/jeks/for_jm/for_jm/hibernate.properties");
    }
}
