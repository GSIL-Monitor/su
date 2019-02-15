package su.spark.api;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RddApiExample implements Serializable {

    private static JavaSparkContext javaSparkContext;
    private static SparkConf sparkConf;
    public RddApiExample(){
        sparkConf = new SparkConf().setMaster("local").setAppName(RddApiExample.class.getName());
        javaSparkContext = new JavaSparkContext(sparkConf);

    }

    @Test
    public void aggregate(){
        JavaRDD<Integer> parallelize = javaSparkContext.parallelize(Arrays.asList(1, 2, 3, 4, 5), 4);
        Integer aggregate = (Integer) parallelize.aggregate(2,
                 (v1, v2) -> {
                     System.out.println("v1:"+v1+"--v2:"+v2+"--v1+v2:"+(v1+v2));
                     return v1 + v2;
                 },  (v1, v2) -> {
                    System.out.println("v1:"+v1+"--v2:"+v2+"--v1*v2:"+(v1*v2));
                    return v1 * v2;
                });
        System.out.println(aggregate);
    }

}
