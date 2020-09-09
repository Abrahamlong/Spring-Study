import com.abraham.service.UserService;
import com.abraham.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @Date 2020/9/9
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理代理的是一个接口（注意）
        UserService userService = (UserService) context.getBean("userService");

        userService.select();
    }
}
