package cn.su;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RunEnvTest {

    public static String getMemoryInfo(){
        Runtime runtime = Runtime.getRuntime();
        long l = runtime.freeMemory();
        long l1 = runtime.totalMemory();
        System.out.println("空闲内存："+l/1024/1024+"M");
        System.out.println("总共内存："+l1/1024/1024+"M");
        return "";
    }

    public static void main(String[] args) {
        RunEnvTest.getMemoryInfo();
    }
}
