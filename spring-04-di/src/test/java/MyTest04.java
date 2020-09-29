import com.abraham.pojo.Student;
import com.abraham.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/7
 */
public class MyTest04 {

    /**
     * 测试使用set依赖注入
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student.toString());
        /**
         * name='long'
         * address=Address{address='福建省龙岩市'}
         * books=[红楼梦, 西游记, 水浒传]
         * hobbys=[听歌, 敲代码, 看电影]
         * card={身份证=666666, 银行卡=888888}
         * games=[LOL, COC, BOB]
         * info={学号=2016551206, 性别=girl, emial=1486460308@qq.com}
         * wife='null'
         */
    }

    /**
     * 测试c命名空间和p命名空间
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");
        User user = context.getBean("user2", User.class);
        System.out.println(user);
    }

    /**
     * 测试Bean的作用域
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");
        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user==user2);
    }

}
