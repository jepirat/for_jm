package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Users(");
        sql.append("id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ");
        sql.append("name TEXT NOT NULL, ");
        sql.append("lastName TEXT NOT NULL, ");
        sql.append("age INT NOT NULL);");

        Transaction transaction = null;
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql.toString() );
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() throws SQLException {
        Transaction transaction = null;
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS Users;");
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO  Users  (name, lastName, age) VALUES (");
        sql.append("'");
        sql.append(name);
        sql.append("'");
        sql.append(", ");
        sql.append("'");
        sql.append(lastName);
        sql.append("'");
        sql.append(", ");
        sql.append("'");
        sql.append(age);
        sql.append("');");
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sql.toString()).executeUpdate();
            transaction.commit();
        }
    }


    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("delete from Users where id =" + id + ";");
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> list = new ArrayList<>();
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createSQLQuery("SELECT *  FROM Users;").addEntity(User.class).list();
            transaction.commit();
        }
        if (list == null) {
            return new ArrayList<User>();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE Users;").executeUpdate();
            transaction.commit();
        }
    }
}
