package com.abraham.mapper;

import com.abraham.pojo.User;

import java.util.List;

/**
 * @author long
 * @date 2020/9/10
 */
public interface UserMapper {
    public List<User> selectUser();
}
