package com.itcast.d_jt_cud;

import com.itcast.utils.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class CUDDemo {

    //添加
    @Test
    public void  testInsert(){
        //1.创建jdbctemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

        //2.编写sql
        String sql = "insert into person values (null,?,?)";

        //3.执行sql
        int i = jdbcTemplate.update(sql, "rose", "男");
        System.out.println(i);
    }

    //修改
    @Test
    public void testUpdate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "update person set name = ? ,sex = ? where id = ?";
        int i = jdbcTemplate.update(sql, "肉丝儿", "女", 4);
    }

    //删除 id=3用户
    @Test
    public void testDelete(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "delete from person where id = ?";
        final int update = jdbcTemplate.update(sql, 3);
    }
}
