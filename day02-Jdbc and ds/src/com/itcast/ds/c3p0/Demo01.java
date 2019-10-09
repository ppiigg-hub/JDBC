package com.itcast.ds.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        PreparedStatement st = conn.prepareStatement("select *from user shere id = ?");
        st.setInt(1,1);
        ResultSet rs = st.executeQuery();
        rs.next();
        System.out.println(rs.getString("username"));


        rs.close();
        st.close();
        conn.close();
    }
}
