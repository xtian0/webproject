package fruit.test;

import fruit.dao.UserDao;
import fruit.dao.impl.UserDaoImpl;
import fruit.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 2:31 pm 14/7/20
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void saveUser() {
        User user = new User(null, "Vincent", "123456", "Vincent@gmail.com");
        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void queryUserByUsernameAndPwd() {
        System.out.println(userDao.queryUserByUsernameAndPwd("Vincent", "123456"));
    }
}