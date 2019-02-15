package cn.su.transaction.springMybatis;

import cn.su.mybatis.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("myDaoWithSpringMyBatisTransaction2")
public class MyDaoWithSpringMyBatisTransactionAnnotation implements MyDaoWithSpringMyBatisTransaction2InfAnnotation {

    @Autowired
    private MyDao myDao;


    @Override
    @Transactional
    public void BatchUpdate(List<Integer> ids){
            for (Integer id : ids) {
                myDao.update(id);
            }
            int i = 1/0;
    }

}
