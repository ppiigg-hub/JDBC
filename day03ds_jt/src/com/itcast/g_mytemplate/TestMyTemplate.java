package com.itcast.g_mytemplate;

import com.itcast.utils.DruidUtils;

public class TestMyTemplate {

    public static void main(String[] args) {
        // 测试插入一条记录

        //1.先创建mytemplate对象
        MyTemplate myTemplate = new MyTemplate(DruidUtils.getDataSource());

        //2.编写sql
        String sql = "insert into person values (?,?,?)";

        //3.执行sql
        System.out.println(myTemplate.update(sql, 20, "jackon", "男"));
    }
}
