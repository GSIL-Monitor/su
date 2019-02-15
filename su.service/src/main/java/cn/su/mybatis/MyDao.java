package cn.su.mybatis;

import cn.su.TaskControlDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class MyDao {
    static Logger logger = LoggerFactory.getLogger(MyDao.class);

    @Autowired
    private SessionConfig sessionConfig;

    public List<TaskControlDomain> getById(String taskId){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("taskId",taskId);
        List<TaskControlDomain> lists = sessionConfig.getSqlsession().selectList("getById", paramMap);
        return lists;
    }

    public int update(Integer id){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        int i = sessionConfig.getSqlsession().update("update",paramMap);
        return i;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDao myDao = (MyDao) applicationContext.getBean("myDao");
        List<TaskControlDomain> byId = myDao.getById("eppbankbalance.autoTask");
        for (TaskControlDomain taskControlDomain : byId) {
            MDC.put("No",taskControlDomain.getTaskId());
            logger.info(taskControlDomain.getTaskId() + "---->" + taskControlDomain.getRunStatus());
        }
    }
    }
