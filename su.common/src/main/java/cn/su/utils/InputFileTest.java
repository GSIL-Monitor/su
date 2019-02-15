package cn.su.utils;

import java.io.*;
import java.util.zip.ZipFile;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InputFileTest {

    public static void main(String[] args) {
        try {
            File file = new File("/opt/logs/temp/33.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            bw.write("wgwpuihwuiehfwuihfpiwfow");
            bw.flush();

        }catch(Exception e){e.printStackTrace();}
    }

}
