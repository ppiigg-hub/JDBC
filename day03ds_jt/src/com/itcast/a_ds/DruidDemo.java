package com.itcast.a_ds;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //获取连接池
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
