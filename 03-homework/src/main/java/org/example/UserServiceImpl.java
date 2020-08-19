package org.example;

import org.example.beans.User;
import org.example.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {

        //使用UserDao,所以UserServiceImpl是依赖UserDao
        //需要给依赖的UserDao 赋值
        userDao.insertUser(user);

    }
}
