package com.itcast.admin;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 和user表进行交互
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    //插入操作
    public int save(User user){
       String sql = "insert into user values(null,?,?)";
       return jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }
}
