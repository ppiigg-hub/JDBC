package com.itcast.f_metadata;

import com.itcast.utils.DruidUtils;
import org.junit.Test;

import java.sql.*;

public class MetaDataDemo {

    //获取参数的元数据
    @Test
    public void testParameterMetaData() throws SQLException {
        //获取connetion
        Connection conn = DruidUtils.getConnection();

        //编写sql
        String sql = "insert into person values(null,?,?);";
        
        //创建PreparedStatement
        PreparedStatement st = conn.prepareStatement(sql);

        //获取参数元数据
        ParameterMetaData metaData = st.getParameterMetaData();

        int parameterCount = metaData.getParameterCount();
        System.out.println("?的个数为:"+parameterCount);
    }


    //获取结果集的元数据
    @Test
    public void testResultSetMetaData() throws SQLException {
        //1.获取连接
        Connection conn = DruidUtils.getConnection();
        //2.编写sql
        String sql = "select sex,id from person where id = ?;";

        //3.获取语句执行对象(预编译)
        PreparedStatement st = conn.prepareStatement(sql);

        //4.直接获取结果集的元数据
        ResultSetMetaData metaData = st.getMetaData();

        //5.获取查询结果的列数
        int columnCount = metaData.getColumnCount();
        System.out.println("总列数为:"+columnCount);

        for (int i = 1; i <= columnCount ; i++) {
            System.out.println("第"+i+"列的列名为:"+metaData.getColumnName(i)+",字段类型为:"+metaData.getColumnTypeName(i));
        }

    }

}
