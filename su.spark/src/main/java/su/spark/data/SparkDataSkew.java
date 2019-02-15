package su.spark.data;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉;
 *  数据倾斜
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SparkDataSkew {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("SparkDataSkew").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        long count = javaSparkContext.textFile("E:\\log\\errorlog.log", 3)
                .flatMap((String line) -> Arrays.asList(line.split("")).iterator()).count();
        System.out.printf("total words : %s", count);
        javaSparkContext.stop();
    }
}
