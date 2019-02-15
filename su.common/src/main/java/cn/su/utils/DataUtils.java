package cn.su.utils;

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
public class DataUtils {

    public static void checkDate(String date) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(date);
        date = matcher.replaceAll("").trim();
        System.out.println(date);
    }

    public static String checkStr(Object str){
        if(null == str) return null;
        return str.toString();
    }

    public static void main(String[] args) {
        DataUtils.checkDate("20tweu19ohvb12-nx 30iac");
    }
}
