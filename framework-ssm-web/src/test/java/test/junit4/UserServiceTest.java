package test.junit4;

import com.jd.frameworkssm.domain.user.User;
import com.jd.frameworkssm.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseTest;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2019/3/10 18:36
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void demoRead() {
        User user = userService.selectById(8L);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
