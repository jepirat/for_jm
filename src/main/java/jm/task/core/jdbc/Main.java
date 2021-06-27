package jm.task.core.jdbc;


import com.mysql.cj.xdevapi.Session;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.saveUser("Test", "test1", (byte) 28);
        userDaoHibernate.getAllUsers().forEach(System.out::println);

       // userDaoHibernate.removeUserById(3);
    }
}
