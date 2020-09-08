import com.abraham.pojo.User;
import com.abraham.pojo.UserTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/7
 */
public class MyTest03 {
    public static void main(String[] args) {
//        User user = new User();

        // Spring容器只要在xml的文件中注册，无论用不用都被注册成功
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        user.show();
    }
}
