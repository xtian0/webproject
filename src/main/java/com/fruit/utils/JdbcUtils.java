package com.fruit.utils;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author : Xin Tian
 * @date : 11:45 pm 13/7/20
 */

public class JdbcUtils {

    /**
     * Get connection of database connection pool.
     */

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();


    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("JDBC.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
//        Connection connection = dataSource.getConnection();
        Connection connection = conns.get();
        if (connection == null){
            connection = dataSource.getConnection();
            conns.set(connection);  //保存到ThreadLocal中，供后面的jdbc操作使用
            connection.setAutoCommit(false);    //设置为手动管理事务
        }
        return connection;
    }

//    /**
//     * Close connection
//     */
//    public static void close(Connection conn){
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null) {   //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove(); //！！！   Tomcat服务器底层使用线程池
    }

    public static void rollBackAndClose(){
        Connection connection = conns.get();
        if (connection != null) {   //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove(); //！！！   Tomcat服务器底层使用线程池
    }
}
