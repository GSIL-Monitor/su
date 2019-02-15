package cn.su;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RegExTest {

    @Test
    public void testRegex(){
        String regEx_2 = "";
        Pattern pattern = Pattern.compile(regEx_2);
        Matcher matcher = pattern.matcher("aa_de_776");
        boolean matches = matcher.matches();
        System.out.println("是否符合正则："+matches);

    }
}
