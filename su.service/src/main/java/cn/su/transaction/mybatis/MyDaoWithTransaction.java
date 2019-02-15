package cn.su.transaction.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.util.Arrays;
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
public class MyDaoWithTransaction {

    static Logger LOGGER = LoggerFactory.getLogger(MyDaoWithTransaction.class);

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    private static SqlSessionFactory initSqlsessionFactory() throws Exception{
        try{
            reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            LOGGER.info("sqlSessionFactory创建成功");
            return sqlSessionFactory;
        }finally {
            if (reader != null){
                reader.close();
            }
        }
    }

    public void batchUpdate(List<Integer> ids){
        SqlSession sqlSession = null;
        try{
        initSqlsessionFactory();
        sqlSession = sqlSessionFactory.openSession(false);
        Map<String, Object> paramMap = new HashMap<>();

            for (Integer id:ids) {
                paramMap.put("id",id);
                sqlSession.update("update",paramMap);
                paramMap.clear();
            }
            sqlSession.commit();
            LOGGER.info("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            LOGGER.error("更新回滚");
        }finally {
            sqlSession.close();
            LOGGER.info("session关闭");
        }

    }

    public static void main(String[] args) {
        MyDaoWithTransaction myDaoWithTransaction = new MyDaoWithTransaction();
        myDaoWithTransaction.batchUpdate(Arrays.asList(451221,451222,451223));
    }

}
