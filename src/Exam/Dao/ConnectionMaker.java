package Exam.Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jaewon on 2015-04-17.
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
