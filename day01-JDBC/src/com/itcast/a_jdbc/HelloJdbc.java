package com.itcast.a_jdbc;

import java.sql.*;

public class HelloJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取连接
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web05","root","1234");
        //编写sql语句
        String sql = "select *from user;";
        //获取语句执行对象
        Statement st = conn.createStatement();
        //执行sql语句，接受返回结果
        ResultSet rs = st.executeQuery(sql);
        //处理返回结果
        while(rs.next()){
            //获取每条记录的id，name，password，
            int id = rs.getInt("id");
            String name = rs.getString("username");
            Object password = rs.getObject("password");
            System.out.println(id+":"+name+":"+password);

        }
        //释放资源
        rs.close();
        st.close();
        conn.close();

    }
}
