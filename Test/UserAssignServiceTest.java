import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/21.
 */
public class UserAssignServiceTest extends BaseTest {
    @Resource  //自动注入,默认按名称
    private DataSourceTransactionManager datasource;

    @Test
    public void test() {
        System.out.println(datasource);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
        Object a = ac.getBean("dataSource");
        System.out.print(a);
        System.out.print(ac);
    }
}
