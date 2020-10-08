package com.abraham.mapper;

import com.abraham.pojo.User;

import java.util.List;

/**
 * @author long
 * @date 2020/9/10
 */
public interface UserMapper {
    // 查询所有用户
    public List<User> selectUser();

    // 添加一个用户
    public int addUser(User user);

    // 删除一个用户
    public int deleteUser(int id);
}
