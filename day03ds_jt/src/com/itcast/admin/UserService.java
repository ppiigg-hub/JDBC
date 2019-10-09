package com.itcast.admin;

public class UserService {
    UserDao userDao = new UserDao();
    //用户注册
    public boolean regist(User user){
        //调用dao完成保存操作即可
        int i = userDao.save(user);
        return i==1;
    }
}
