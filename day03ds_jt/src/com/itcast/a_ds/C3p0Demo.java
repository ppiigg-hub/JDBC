package com.itcast.a_ds;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();

    }
}
