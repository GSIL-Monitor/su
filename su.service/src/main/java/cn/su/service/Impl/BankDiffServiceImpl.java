package cn.su.service.Impl;

import cn.su.BankDiffInfo;
import cn.su.mybatis.BankDiffInfoDao;
import cn.su.service.BankDiffService;
import cn.su.utils.DataUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class BankDiffServiceImpl implements BankDiffService {
    Logger logger = LoggerFactory.getLogger(BankDiffServiceImpl.class);

    @Autowired
    private BankDiffInfoDao bankDiffInfoDao;

    @Override
    public void readExcelFleToDb(String filePath) {
        try {
            XSSFWorkbook xssfSheets = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = xssfSheets.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            List<BankDiffInfo> dataLists = new ArrayList<>();

            for (int i = 0; i < lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i + 1);
                BankDiffInfo bankDiffInfo = new BankDiffInfo();
                bankDiffInfo.setTranBatchNo(DataUtils.checkStr(row.getCell(0)));
                bankDiffInfo.setCompanyCode(DataUtils.checkStr(row.getCell(12)));
                bankDiffInfo.setDiffDescribe(DataUtils.checkStr(row.getCell(9)));
                bankDiffInfo.setOldPayTime(DataUtils.checkStr(row.getCell(8)));
                bankDiffInfo.setPayInsitution(DataUtils.checkStr(row.getCell(10)));
                bankDiffInfo.setPayNo(DataUtils.checkStr(row.getCell(5)));
                bankDiffInfo.setReciInsitution(DataUtils.checkStr(row.getCell(11)));
                bankDiffInfo.setSapId(DataUtils.checkStr(row.getCell(2)));
                bankDiffInfo.setSubjectNo(DataUtils.checkStr(row.getCell(6)));
                bankDiffInfo.setTranAmount(new BigDecimal(DataUtils.checkStr(row.getCell(4))));
                bankDiffInfo.setTranDate(DataUtils.checkStr(row.getCell(1)));
                bankDiffInfo.setTranNo(DataUtils.checkStr(row.getCell(7)));
                bankDiffInfo.setTranType(DataUtils.checkStr(row.getCell(3)));
                dataLists.add(bankDiffInfo);
            }
            long start = System.currentTimeMillis();
            bankDiffInfoDao.insertBatch(dataLists);
            logger.info("插入耗时:{}",(System.currentTimeMillis()-start));
        } catch (Exception e) {
            logger.error("异常：{}"+e);
        }

    }

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
            BankDiffServiceImpl bankDiffServiceImpl = (BankDiffServiceImpl) applicationContext
                    .getBean("bankDiffServiceImpl");
            bankDiffServiceImpl.readExcelFleToDb("D:\\googledownloads\\银行差异数据_20190117140404.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
