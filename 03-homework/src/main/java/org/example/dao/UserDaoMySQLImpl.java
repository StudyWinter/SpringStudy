package org.example.dao;

import org.example.beans.User;

public class UserDaoMySQLImpl implements UserDao {


    @Override
    public void insertUser(User user) {
        System.out.println("使用了Mysql 的insert添加用户");
    }
}
