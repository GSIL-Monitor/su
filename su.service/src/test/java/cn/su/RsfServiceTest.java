package cn.su;

import com.suning.rsf.consumer.Future;
import com.suning.rsf.consumer.ServiceAgent;
import com.suning.rsf.consumer.ServiceLocator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RsfServiceTest {

    @Test
    public void test() {

        ServiceAgent service = ServiceLocator.getServiceAgent("com.suning.epps.cap.bank.rsf.api.BankAccountRecordApi", "bankAccountRecordApi",false);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            resultMap = (Map<String, Object>)service.invoke("manualRemoteAccount", new Object[]{resultMap}, new Class[]{java.util.Map.class});

            System.out.println("获取数据;"+resultMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
