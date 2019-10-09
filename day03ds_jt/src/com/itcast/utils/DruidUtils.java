package com.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    //一个项目中一般只用一个连接池,用static修饰
    private static DataSource ds;

    //通过静态代码块初始化ds
    static{

        try {
            //读取配置文件
            Properties prop = new Properties();
            prop.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化ds
            ds = DruidDataSourceFactory.createDataSource(prop);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
