package com.itcast.b_curd;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CURDDemo {


    @Test
    //测试插入数据
    public void restInsert() throws ClassNotFoundException, SQLException {
        //1.获取连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///web05", "root", "1234");
        //2.编写sql
        String sql = "insert into user values(null,'rose','1234')";

        //3.获取语句执行对象
        Statement st = conn.createStatement();
        //4.执行语句
        int i = st.executeUpdate(sql);
        //5.处理结果
        if(i>0){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        //6.释放资源
        st.close();
        conn.close();

    }
}
