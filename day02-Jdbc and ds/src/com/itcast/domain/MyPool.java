package com.itcast.domain;

import com.itcast.utils.JdbcUtils;

import com.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyPool {

    private ArrayList<Connection> list = new ArrayList<>();

    public MyPool(){
        for(int i = 0 ; i<3 ; i++){
            try {
                list.add( JdbcUtils.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        return list.remove(0);
    }

    public void addBack(Connection conn){
        list.add(conn);
    }
}
