import com.abraham.mapper.UserMapper;
import com.abraham.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @date 2020/9/10
 */
public class MyTest11 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user :userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}
