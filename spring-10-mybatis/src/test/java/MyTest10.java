import com.abraham.mapper.UserMapper;
import com.abraham.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.util.Resources_es;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author long
 * @date 2020/9/10
 */
public class MyTest10 {
    @Test
    public void test() throws IOException {
        /**
         * Mybatis的原生配置实现方法
        String resource = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users) {
            System.out.println(user);
        }
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapperTwo", UserMapper.class);

        for (User user: userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}
