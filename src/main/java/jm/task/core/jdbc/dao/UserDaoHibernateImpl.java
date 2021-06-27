package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Users(");
        sql.append("id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ");
        sql.append("name text NOT NULL, ");
        sql.append("lastName text NOT NULL, ");
        sql.append("age INT NOT NULL);");

        Transaction transaction = null;
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql.toString() );
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            throw e;
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
        } catch (Exception e) {
            throw e;
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Transaction transaction = null;
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
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
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
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

        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        List<User> list = new ArrayList<>();
        try (Session session =  Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE Users;").executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            throw e;
        }
    }
}
