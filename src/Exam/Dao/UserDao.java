package Exam.Dao;
/**
 * Created by Jaewon on 2015-04-17.
 */
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {

    private  dataSource;
    private  DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public UserDao(){

    }
    public static User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "select id, name, password from userinfo where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

    public static void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userinfo(id, name, password) values(?,?,?)");

        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }


}