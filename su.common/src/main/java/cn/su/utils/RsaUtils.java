package cn.su.utils;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RsaUtils {

    /**
     * 功能描述: ;
     *  RSA加解密
     * @param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */

    @Test
    public void testEncryRsa(){
        try{
            System.out.println(ConfigTools.encrypt("eppscap"));
            System.out.println(ConfigTools.encrypt("tXEv686OkMKy"));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
