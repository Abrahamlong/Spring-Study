import com.abraham.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/5
 */

public class MyTest01 {
    public static void main(String[] args) {
        /**
         * 传统的方法去new对象
        // 用户实际调用的是业务层，dao层他们不需要接触
        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoImpl());

        userService.getUser();
        */

        /**
         * 通过配置文件去创建对象，对象由Spring的配置文件去创建
         */
        // 获取ApplicationContext:拿到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 容器在手，天下我有，需要什么，就直接get什么！
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
