package cn.su.transaction.springMybatis;

import cn.su.mybatis.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service
public class MyDaoWithTransactionTemplate {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private MyDao myDao;

    public void updateBatch(final List<Integer> ids){
        transactionTemplate.execute(new TransactionCallback<Integer>() {

            @Override
            public Integer doInTransaction(TransactionStatus status) {
                int update = 0;
                for(Integer id : ids) {
                     update += myDao.update(id);
                }
                /*int j = 1/0;*/
                return update;
            }
        });
    }

}
