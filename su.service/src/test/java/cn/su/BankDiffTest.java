package cn.su;

import cn.su.service.BankDiffService;
import cn.su.service.Impl.BankDiffServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-config.xml")
public class BankDiffTest {

    @Autowired
    private BankDiffService bankDiffService;

    @Test
    public void test() {
        try {
            bankDiffService.readExcelFleToDb("D:\\googledownloads\\银行差异数据_20190117140404.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
