package cn.su.transaction.springMybatis;

import cn.su.Exception.SuException;
import cn.su.mybatis.MyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Component
public class MyDaoWithSpringMyBatisTransaction {
    Logger logger = LoggerFactory.getLogger(MyDaoWithSpringMyBatisTransaction.class);
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private MyDao myDao;

    public void BatchUpdate(List<Integer> ids){
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        int i = 0;
        try{
            for(Integer id : ids){
                i++;
                myDao.update(id);
                if(i == 2){
                    throw new SuException("2错误");
                }
            }
            transactionManager.commit(transactionStatus);
            logger.info("更新成功");
        }catch(Exception e){
            e.printStackTrace();
            if(transactionStatus != null){
                transactionManager.rollback(transactionStatus);
                logger.error("事物回滚");
            }
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDaoWithSpringMyBatisTransaction myDaoWithSpringMyBatisTransaction = (MyDaoWithSpringMyBatisTransaction) applicationContext.getBean("myDaoWithSpringMyBatisTransaction");
        myDaoWithSpringMyBatisTransaction.BatchUpdate(Arrays.asList(451221,451222));
    }

}
