package com.fruit.dao;

import com.fruit.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : Xin Tian
 * @date : 12:30 am 14/7/20
 */
public abstract class BaseDao {
    private QueryRunner queryRunner= new QueryRunner();


    /**
     * Update: Insert\Update\Delete
     * @param sql
     * @param args
     * @return 影响的行数/-1
     */
    public int update(String sql, Object...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.update(conn, sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        //If failed, return -1.
        return -1;
    }

    /**
     * 查询一个javaBean
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return 影响的行数/null
     */
    public <T> T queryForOne(Class<T> type, String sql, Object...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        //If failed, return null.
        return null;
    }

    public <T> List<T> queryForlist(Class<T> type, String sql, Object...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        //If failed, return null.
        return null;

    }

    public Object queryForSingleValue(String sql, Object...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
//            String sql = "select count(*) from user";
//            String sql = "select max(DOB) from user";
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
//            Date maxBirth = (Date) runner.query(conn, sql, handler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}
