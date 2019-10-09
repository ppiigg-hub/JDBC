package com.itcast.g_mytemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyTemplate {

    private  DataSource dataSource;

    public MyTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }


    /**
     * 编写通用的update方法
     * @param sql 要执行的sql
     * @param args sql中?的参数
     * @return 影响的行数
     */
    public int update(String sql,Object ... args) {
        Connection conn =null;
        PreparedStatement st =null;
        int result = 0;
        try {
            //1.获取连接
            conn = dataSource.getConnection();

            //2.获取PreparedStatement对象
            st = conn.prepareStatement(sql);

            //3.设置参数 (通过元数据)
            ParameterMetaData metaData = st.getParameterMetaData();
            //获取参数的个数 ,给每个参数设置值
            int count = metaData.getParameterCount();
            for (int i = 1; i <= count ; i++) {
                st.setObject(i,args[i-1]);
            }

            //4.执行sql
            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
