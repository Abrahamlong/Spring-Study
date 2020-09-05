package com.longlong.service;

import com.longlong.dao.UserDao;
import com.longlong.dao.UserDaoImpl;
import com.longlong.dao.UserDaoMysqlImpl;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/5
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoMysqlImpl();

    public void getUser() {
        userDao.getUser();
    }
}
