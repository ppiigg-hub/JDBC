package com.itcast.admin;

import java.util.Scanner;

public class TestAdmin {
    public static void main(String[] args) {
        //1.接收用户输入的用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();

        //2.将用户名和密码封装成user对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //3.调用userservice的regist方法，完成保存操作，接收返回值
        UserService userService = new UserService();
        boolean result = userService.regist(user);


        //4.根据返回值，提示用户
        if(result){
            System.out.println("注册成功");
        }else{
            System.out.println("请稍后再试");
        }

    }
}
