package cn.su.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.su.TaskControlDomain;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class JdbcTemplateDemo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TaskControlDomain> queryByContition(){
        List<TaskControlDomain> lists = jdbcTemplate
                .query("select * from cap_bank_task_control", new RowMapper<TaskControlDomain>() {
                    @Override
                    public TaskControlDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
                        TaskControlDomain taskControlDomain = new TaskControlDomain();
                        taskControlDomain.setRunStatus(rs.getString("TASK_RUN_STATUS"));
                        taskControlDomain.setTaskId(rs.getString("TASK_ID"));
                        return taskControlDomain;
                    }
                });

        return lists;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(JdbcTemplateDemo.class);
        ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplateDemo jdbcTemplateDemo = (JdbcTemplateDemo) applicationContext.getBean("jdbcTemplateDemo");
        List<TaskControlDomain> taskControlDomains = jdbcTemplateDemo.queryByContition();
        for (TaskControlDomain domain: taskControlDomains){
            logger.info(domain.getTaskId()+"-->"+domain.getRunStatus());
            logger.error(domain.getTaskId()+"-->"+domain.getRunStatus());

        }
    }



}
