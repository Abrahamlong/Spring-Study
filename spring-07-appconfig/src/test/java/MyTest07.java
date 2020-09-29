import com.abraham.config.LongConfig;
import com.abraham.pojo.Student;
import com.abraham.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author long
 * @date 2020/9/8
 */
public class MyTest07 {
    public static void main(String[] args) {
        // 如果完全使用了配置类方式去做，我们就只能通过AnnotationConfigApplicationContext上下文来获取容器，通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(LongConfig.class);

        User user = (User) context.getBean("user"); //参数名为配置类中@Bean注解的方法名
        System.out.println(user.getName());

        Student student = (Student) context.getBean("student");
        System.out.println(student.getStudentId());
    }
}
