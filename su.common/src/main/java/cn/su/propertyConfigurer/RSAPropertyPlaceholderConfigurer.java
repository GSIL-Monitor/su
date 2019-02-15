package cn.su.propertyConfigurer;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RSAPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    Logger LOGGER = LoggerFactory.getLogger(RSAPropertyPlaceholderConfigurer.class);

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        long startTime = System.currentTimeMillis();
        String decrypt = null;
        try{
            if(isEncryProperty(propertyName)){
                 decrypt = ConfigTools.decrypt(propertyValue);
            }else{
                decrypt = propertyValue;
            }

        }catch(Exception e){
            e.printStackTrace();
            LOGGER.error("解析错误");
        }finally {
            long endTime = System.currentTimeMillis();
            LOGGER.info("propertyName:{}解密消耗时间:{}：",new Object[]{propertyName,(endTime-startTime)});
        }
        return decrypt;
    }

    private boolean isEncryProperty(String propertyName) {
       if(propertyName.indexOf("pwd")!=-1 || propertyName.indexOf("password")!=-1
               || propertyName.indexOf("passwords")!=-1 ||propertyName.indexOf("pwds")!=-1
       ){
           return true;
       }else{
           return false;
       }
    }
}
