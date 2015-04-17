package Exam.Dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jaewon on 2015-04-17.
 */
@Configuration
public class DaoFactory {
    @Bean
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }
    @Bean
    public DConnectionMaker getConnectionMaker() {
        return new DConnectionMaker();
    }
}
