package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Test", "test1", (byte) 28);
        userServiceImpl.saveUser("test2", "test3", (byte) 40);
        userServiceImpl.saveUser("test4", "test5", (byte) 80);
        userServiceImpl.saveUser("test6", "test7", (byte) 100);
        userServiceImpl.removeUserById(2);
        userServiceImpl.getAllUsers().forEach(System.out::println);
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
