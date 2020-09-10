package com.abraham.mapper;

import com.abraham.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author long
 * @date 2020/9/10
 */
public class UserMapperImpl implements UserMapper {

    // 在原来我们的所有操作都使用sqlSession来执行，现在都使用 SqlSessionTemplate；
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
