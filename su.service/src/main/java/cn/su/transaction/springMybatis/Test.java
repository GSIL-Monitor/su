package cn.su.transaction.springMybatis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Test {

    @Autowired
    private MyDaoWithSpringMyBatisTransaction2InfAnnotation myDaoWithSpringMyBatisTransaction2;

    @Autowired
    private MyDaoWithTransactionTemplate myDaoWithTransactionTemplate;

    @org.junit.Test
    public void test(){
        myDaoWithSpringMyBatisTransaction2.BatchUpdate(Arrays.asList(451221,451222));
    }
    @org.junit.Test
    public void test2(){
        myDaoWithTransactionTemplate.updateBatch(Arrays.asList(451221,451222));
    }
}
