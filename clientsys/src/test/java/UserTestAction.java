import com.ljo.dto.User;
import com.ljo.service.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jb.liang on 2017/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTestAction {

    private static Log LOGGER = LogFactory.getLog(UserTestAction.class);

    @Resource
    private IUserService userService = null;

    @Test
    public void getUserTest(){
        User user = userService.getuserById(1);
        if(user != null){
            LOGGER.info("用户名：" + user.getUsername());
            LOGGER.info("密  码：" + user.getPassword());
        } else {
            LOGGER.info("测试失败！");
        }
    }
}
