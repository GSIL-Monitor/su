package cn.su.mybatis;

import cn.su.BankDiffInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BankDiffInfoDao {

    @Autowired
    private SessionConfig sessionConfig;

    public int insertBatch(List<BankDiffInfo> datas){

        int insertBatch = sessionConfig.getSqlsession().insert("insertBatch", datas);

        return insertBatch;
    }

}
