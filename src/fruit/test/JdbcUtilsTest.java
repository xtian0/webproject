package fruit.test;

import fruit.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : Xin Tian
 * @date : 12:12 am 14/7/20
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtils.close(conn);
    }
}
