package cn.su.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class SessionConfig  {
    Logger logger = LoggerFactory.getLogger(SessionConfig.class);

    @Autowired
    private SqlSession sqlSession;

    public SqlSession getSqlsession(){
        logger.info("数据库连接：---<<"+sqlSession.getConnection().hashCode()+">>---");
        return sqlSession;
    }


}
