package com.itcast.b_curd;

import com.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestUtils {

    //删除id=4的记录
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //编写sql
            String sql = "delete from user where id = 5";
            //获取语句执行对象
            st = conn.createStatement();
            //执行sql
            int i = st.executeUpdate(sql);
            //处理结果
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}