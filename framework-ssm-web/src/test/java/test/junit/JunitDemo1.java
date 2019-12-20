package test.junit;

import com.jd.frameworkssm.domain.user.User;
import com.jd.frameworkssm.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/3/10 15:47
 */
public class JunitDemo1 {
    @Test
    public void demoRead() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.selectById(8L);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
