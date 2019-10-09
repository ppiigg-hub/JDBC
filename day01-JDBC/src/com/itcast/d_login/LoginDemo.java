package com.itcast.d_login;

import com.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {
        //1. 友情提示用户输入用户名和密码  scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();


        //2. 获取用户名和密码
        //3. 编写sql
        String sql = "select *from user where username = '"+username+"' and password = '"+password+"' limit 1";


        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            //4. 执行查询sql,返回值resultset
            rs = st.executeQuery(sql);

            //5. 判断resultset是否有值
            if(rs.next())  {
                //5.1. 若有,在控制台打印:欢迎你,xxx
                System.out.println("欢迎你:"+username);
            }else{
                //5.2. 若无,在控制台打印:
                System.out.println("用户名或者密码错误");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}
