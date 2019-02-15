package cn.su.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExcelUtils {

    public static final int VERSION_03 = 3;
    public static final int VERSION_07 = 7;

    public static Workbook getWorkBook(Integer version) {
        Workbook workbook = null;
        if (VERSION_03 == version) {
            workbook = new XSSFWorkbook();
        } else if (VERSION_07 == version) {
            workbook = new HSSFWorkbook();
        }
        return workbook;
    }

    /**
     * 功能描述: ;
     * 导出数据到excel
     *
     * @param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void exportDataToExcel(List<Map<String, Object>> datas, String[] titles, String[] ch_titles,
            String fileName) throws Exception {
        Workbook workBook = getWorkBook(3);
        Sheet sheet = workBook.createSheet();
        Row headRow = sheet.createRow(0);
        for (int i = 0; i < ch_titles.length; i++) {
            Cell cell = headRow.createCell(i);
            cell.setCellValue(ch_titles[i]);
        }
        for (int i = 1; i <= datas.size(); i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j<titles.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(datas.get(i-1).get(titles[j]).toString());
            }
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(new File("E:\\files\\" + fileName)));
        workBook.write(bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    @Test
    public void testExportDataToExcel() {
        String[] title = new String[] { "id", "name", "age", "sex" };
        String[] ch_title = { "编号", "姓名", "年龄", "性别" };
        List<Map<String, Object>> datas = new ArrayList<>();
        int n = 1000;
        while (n > 0) {
            n--;
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < title.length; i++) {
                map.put(title[i], getValue(i,n));
            }
            datas.add(map);

        }
        try {
            ExcelUtils.exportDataToExcel(datas, title, ch_title, "人员统计表.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Object getValue(int i,int n) {
        String[] names = { "james", "toms", "chily", "sharly", "goojuy", "timee", "pooly", "fludd", "kebii", "durante",
                "averson", "cooky" };
        String[] sexs = { "male", "female" };
        Object o = null;
        switch (i) {
            case 0:
                o = "201900120" + n;
                break;
            case 1:
                o = names[new Random().nextInt(names.length)];
                break;
            case 2:
                o = new Random().nextInt(20) + i;
                break;
            case 3:
                o = sexs[new Random().nextInt(2)];
                break;
            default:
                break;
        }
        return o;
    }
}
