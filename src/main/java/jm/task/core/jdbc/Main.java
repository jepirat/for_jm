package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Test", "test1", (byte) 28);
        userServiceImpl.saveUser("test2", "test3", (byte) 40);
        userServiceImpl.saveUser("test4", "test5", (byte) 80);
        userServiceImpl.saveUser("test6", "test7", (byte) 100);
        userServiceImpl.getAllUsers().forEach(System.out::println);
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
