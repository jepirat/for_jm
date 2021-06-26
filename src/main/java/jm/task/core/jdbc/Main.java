package jm.task.core.jdbc;

import com.mysql.cj.xdevapi.Session;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Session session = Util.getConnect();
        session.createSchema("Users");
        session.getSchema("Users");

    }
}
