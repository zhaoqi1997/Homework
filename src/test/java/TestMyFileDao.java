import com.zq.dao.MyFileDao;
import com.zq.entity.MyFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhaoqi
 * @version 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config/spring-core.xml")
public class TestMyFileDao {
    @Autowired
    private MyFileDao myFileDao;
    @Test
    public void test(){
        List<MyFile> myFiles = myFileDao.selectAll();
        myFiles.forEach(file -> System.out.println(file));
    }
}
