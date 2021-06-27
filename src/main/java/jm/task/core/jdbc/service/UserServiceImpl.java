package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() throws SQLException {
        new UserDaoHibernateImpl().createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        new UserDaoHibernateImpl().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        new UserDaoHibernateImpl().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
       new UserDaoHibernateImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        new UserDaoHibernateImpl().getAllUsers();
        return null;
    }

    public void cleanUsersTable() {
        new UserDaoHibernateImpl().cleanUsersTable();
    }
}
