package fruit.dao.impl;

import fruit.dao.BaseDao;
import fruit.dao.UserDao;
import fruit.pojo.User;

/**
 * @author : Xin Tian
 * @date : 2:05 pm 14/7/20
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, email from user where username = ? ";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(username, password, email)values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPwd(String username, String password) {
        String sql = "select id, username, password, email from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }
}
