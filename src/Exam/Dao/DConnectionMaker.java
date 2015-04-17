package Exam.Dao;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Driver;

/**
 * Created by Jaewon on 2015-04-17.
 */


public class DConnectionMaker extends SimpleDriverDataSource {
    public DConnectionMaker(){
        this.setDriverClass(Driver.class);
        this.setUrl("com.mysql.jdbc.Driver");
        this.setUsername("jeju");
        this.setPassword("jejupw");
    }
}


//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection= DriverManager.getConnection("jdbc:mysql://117.17.102.143/spring?characterEncoding=utf-8", "root", "Starter");
//        return connection;

