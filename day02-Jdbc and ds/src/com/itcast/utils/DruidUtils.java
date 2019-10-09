package com.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;

    static{
        try {
            //1.加载配置文件
            Properties prop = new Properties();
            prop.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.创建一个连接池对象,一个项目中一般只需要一个连接池即可
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //3.提供获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //4.获取连接池的方法
    public static DataSource getDataSource(){
        return ds;
    }

}
