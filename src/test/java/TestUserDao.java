import com.zq.dao.UserDao;
import com.zq.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaoqi
 * @version 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config/spring-core.xml")
public class TestUserDao {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        User user = userDao.selectByUsername("123456");
        System.out.println(user);
    }

    @Test
    public void test1(){
        String yyyyMMdd = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        System.out.println(yyyyMMdd);

        String sufferName = "a.jsp".substring("a.jsp".lastIndexOf("."));
        System.out.println(sufferName);
    }

    @Test
    public void test2(){
        String s1 = "D://files/";String s2 = "a";
        File file =new File(s1+s2);
        file.mkdirs();
    }


}
