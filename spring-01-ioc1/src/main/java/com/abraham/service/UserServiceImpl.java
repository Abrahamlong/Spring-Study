package com.abraham.service;

import com.abraham.dao.UserDao;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/5
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
