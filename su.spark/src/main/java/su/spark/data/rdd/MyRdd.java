package su.spark.data.rdd;

import org.apache.spark.Dependency;
import org.apache.spark.Partition;
import org.apache.spark.SparkContext;
import org.apache.spark.TaskContext;
import org.apache.spark.rdd.RDD;
import scala.collection.Iterator;
import scala.collection.Seq;
import scala.reflect.ClassTag;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyRdd extends RDD {


    public MyRdd(SparkContext _sc, Seq<Dependency<?>> deps,
            ClassTag evidence$1) {
        super(_sc, deps, evidence$1);
    }

    @Override
    public Iterator compute(Partition split, TaskContext context) {
        return null;
    }

    @Override
    public Partition[] getPartitions() {
        return new Partition[0];
    }
}
