package Exam.Test;

/**
 * Created by Jaewon on 2015-04-17.
 */

import Exam.Dao.DaoFactory;
import Exam.Dao.User;
import Exam.Dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = context.getBean("userDao",UserDao.class);
    }
    @Test
    public void get() throws ClassNotFoundException, SQLException {
        UserDao userDao = new DaoFactory().getUserDao();
        String id = String.valueOf(new Random().nextInt());
        String name = "허윤호";
        String password = "1111";
        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId(String.valueOf(new Random().nextInt()));
        user.setName("허윤호");
        user.setPassword("1234");

        UserDao DUserDao = new DaoFactory().getUserDao();
        DUserDao.add(user);
        User addedUser = DUserDao.get(user.getId());
        User addedId = DUserDao.get(user.getName());
        User addedPassword = DUserDao.get(user.getPassword());

        assertEquals("10", addedUser.getId());
        assertEquals("허윤호", addedId.getName());
        assertEquals("1234", addedPassword.getPassword());
    }
}