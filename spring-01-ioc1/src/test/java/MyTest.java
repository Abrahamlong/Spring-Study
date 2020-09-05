import com.longlong.service.UserService;
import com.longlong.service.UserServiceImpl;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/5
 */

public class MyTest {
    public static void main(String[] args) {
        // 用户实际调用的是业务层，dao层他们不需要接触
        UserService userService = new UserServiceImpl();

        userService.getUser();
    }
}
