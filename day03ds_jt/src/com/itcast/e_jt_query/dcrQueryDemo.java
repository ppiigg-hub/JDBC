package com.itcast.e_jt_query;

import com.itcast.domain.Person;
import com.itcast.utils.DruidUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class dcrQueryDemo {
    JdbcTemplate jdbcTemplate;
    @Before
    public void before(){
        jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    }


    //查询总记录数
    @Test
    public void testGetTotalRecord(){
        String sql = "select count(1) from person;";
        Integer i = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数为:"+i);
    }

    //查询id=4的记录
    @Test
    public void testFindById4Map(){
        String sql = "select * from person where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 4);//若找不到记录会报错
        System.out.println(map);
    }

    //查询所有的记录
    @Test
    public void testFindAll4List(){
        String sql = "select * from person";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }


    //查询id=4的记录,将结果封装成person对象
    @Test
    //了解
    public void testFindById4Object1(){
        String sql = "select * from person where id = ?";
        Person p1 = jdbcTemplate.queryForObject(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                //将记录转成person返回
                Person p = new Person();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setSex(rs.getString("sex"));
                return p;
            }
        }, 4);

        System.out.println(p1);
    }

    //掌握
    @Test
    public void testFindById4Object2(){
        String sql = "select * from person where id = ?";
        Person p1 = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Person>(Person.class),4);
        System.out.println(p1);
    }

    //查询所有的记录,将每条记录封装成person对象,将所有的对象放入list中返回
    @Test
    public void testFindAll4List2(){
        String sql = "select * from person";
        List<Person> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println(list);
    }


}
