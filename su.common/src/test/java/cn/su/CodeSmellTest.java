package cn.su;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.reflect.io.File;

import java.text.MessageFormat;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CodeSmellTest {
    private Logger logger = LoggerFactory.getLogger(CodeSmellTest.class);

    @Test
    public void test(){
        System.out.println(String.format("First %s and then %s", "foo", "bar"));
        System.out.println(String.format("Display %2$d and then %d", 1, 3));
        System.out.println(String.format("Too many arguments %d %d", 1, 2));
        System.out.println(String.format("First Line%n"));
        System.out.println(String.format("Is myObject null ? %b", "" == null));
        System.out.println(MessageFormat.format("Result {0}.", "test"));
        System.out.println(MessageFormat.format("Result '{0}' = {0}", "test"));
        System.out.println(MessageFormat.format("Result {0}.", "test"));
        logger.info("Result {0}.", "test");
        logger.info("Result {0}'", 14);
    }

    @Test
    public void testIndexof(){
        String words = "HelloWorld";
        for(int i = 0; i<1000; i++){

            long startTime = System.currentTimeMillis();
            int index = words.indexOf("d");
            System.out.println(System.currentTimeMillis()-startTime);
            long startTime1 = System.currentTimeMillis();
            int index1 = words.indexOf('d');
            System.out.println(System.currentTimeMillis()-startTime1);
        }
    }

    @Test
    public void testReturnValue(){
        String sql = "select * from tbl_test;";
        sql = sql.replace(";", "");
        System.out.println(sql);
        System.out.println(System.getProperty("file.separator"));

    }

}
