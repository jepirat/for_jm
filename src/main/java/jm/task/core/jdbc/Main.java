package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
       UserServiceImpl userService = new UserServiceImpl();
       userService.createUsersTable();
       userService.saveUser("jeka", "pettov", (byte) 35);
       userService.saveUser("petya", "sidorov", (byte) 38);
       userService.saveUser("vasja", "turkon", (byte) 45);
       userService.saveUser("gena", "popovich", (byte) 59);
       List<User> allUsers = userService.getAllUsers();
       allUsers.forEach(System.out::println);
       userService.cleanUsersTable();
       userService.dropUsersTable();
    }
}
