package com.itcast.c_jt_hello;

import com.itcast.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class HelloDemo {
    public static void main(String[] args) {
        //1.创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

        //2.编写sql
        String sql = "create table person (id int primary key auto_increment,name varchar(20),sex varchar(2))";

        //3.执行sql
        jdbcTemplate.execute(sql);
    }
}
