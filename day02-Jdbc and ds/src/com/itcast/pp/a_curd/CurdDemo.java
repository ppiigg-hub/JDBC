package com.itcast.pp.a_curd;

import com.itcast.domain.User;
import com.itcast.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CurdDemo {
    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接

            //2.编写sql

            //3.获取预编译语句执行对象

            //4.设置参数

            //5.执行sql

            //6.处理结果

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
    @Test
    public void testDeleteByld(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接
            conn = JdbcUtils.getConnection();
            //2.编写sql
            String sql = "delete from user where id = ?;";
            //String sql = "update user set isdel = ?  where id = ?";

            //3.获取预编译语句执行对象
            st = conn.prepareStatement(sql);
            //4.设置参数
            st.setString(1,"3");

            //5.执行sql
            int i = st.executeUpdate();
            System.out.println(i);
            //6.处理结果

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }

    @Test
    public void testFindAll(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接
            conn = JdbcUtils.getConnection();

            //2.编写sql
            String sql = "select *from user";
            //3.获取预编译语句执行对象
            st = conn.prepareStatement(sql);


            //4.设置参数

            //5.执行sql
            rs = st.executeQuery();

            //6.创建一个Arraylist 用来存放user对象
            List<User> list = new ArrayList<>();

            //7.遍历结果集,将每条记录封装成user,将每个user放入list中
            while (rs.next()) {
                //获取到记录中的id , username,password
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                //创建一个user对象
                User user = new User();

                //将三个值设置给user即可
                user.setUsername(username);
                user.setPassword(password);
                user.setId(id);

                //放入集合中
                list.add(user);
            }
            //处理结果
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接
            conn = JdbcUtils.getConnection();

            //2.编写sql
            String sql = "update user set username = ? , password = ? where id = ?";

            //3.获取预编译语句执行对象
            st = conn.prepareStatement(sql);

            //4.设置参数
            st.setString(1,"肉丝儿");
            st.setString(2,"123");
            st.setInt(3,6);
            //st.setString(3,"5");//也可以

            //5.执行sql
            int i = st.executeUpdate();

            //6.处理结果
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    @Test
    //插入
    public void testInsert(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接
            conn = JdbcUtils.getConnection();

            //2.编写sql
            String sql = "insert into user values (null,?,?);";

            //3.获取语句执行对象
            st = conn.prepareStatement(sql);

            //3.1 设置参数
            st.setString(1,"rose");
            st.setString(2,"qwe");

            //4.执行sql
            int i = st.executeUpdate();

            //5.处理结果
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}

