package Exam.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jaewon on 2015-04-17.
 */
public class DConnectionMaker implements ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://117.17.102.143/spring?characterEncoding=utf-8", "root", "Starter");
        return connection;
    };
}
