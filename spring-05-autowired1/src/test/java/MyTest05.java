import com.abraham.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long
 * @date 2020/9/8
 */
public class MyTest05 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("contextBeans.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shout();
        people.getDog().shout();
    }
}
