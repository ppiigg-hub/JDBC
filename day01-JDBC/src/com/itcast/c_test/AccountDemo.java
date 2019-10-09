package com.itcast.c_test;

import com.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDemo {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //获取语句执行对象
            st = conn.createStatement();

            //开启事务
            conn.setAutoCommit(false);

            //汇款方-
            String sql = "update account set money = money - 100 where id = 1";
            int i = st.executeUpdate(sql);
            if (i!=1) {
                throw new RuntimeException("扣钱失败");
            }



            //收款方+
            sql = "update account set money = money + 100 where id = 2";
            i = st.executeUpdate(sql);
            if (i!=1) {
                throw new RuntimeException("加钱失败");
            }

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}

