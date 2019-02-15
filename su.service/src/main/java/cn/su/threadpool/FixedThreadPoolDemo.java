package cn.su.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FixedThreadPoolDemo {

    /**
     * 功能描述: ;
     * 执行流程：
     *    1.线程池会先创建固定数量的线程对象
     *    2.请求进来，先查看有没有可用的线程对象，如果没有则等待，直到有可用的线程对象可用。
     *    3.执行完后，线程不会销毁，会永久保留，除非你手动停掉。
     * @param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */

    @Test
    public void test(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        TaskThread taskThread1 = new TaskThread();
        TaskThread taskThread2 = new TaskThread();
        TaskThread taskThread3 = new TaskThread();
        TaskThread taskThread4 = new TaskThread();
        long startTime = System.currentTimeMillis();
        System.out.println("进入taskThread1:"+System.currentTimeMillis());
        fixedThreadPool.execute(taskThread1);
        System.out.println("进入taskThread2:"+System.currentTimeMillis());
        fixedThreadPool.execute(taskThread2);
        System.out.println("进入taskThread3:"+System.currentTimeMillis());
        fixedThreadPool.execute(taskThread3);
        System.out.println("进入taskThread4:"+System.currentTimeMillis());
        fixedThreadPool.execute(taskThread4);
        long endTime = System.currentTimeMillis();
        System.out.println("执行4个线程调度时间为："+(endTime-startTime));
        fixedThreadPool.shutdown();
    }

    private class TaskThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前是线程："+Thread.currentThread().getName()+"在执行:"+System.currentTimeMillis());
            try{
                //                Thread.sleep(1000L);
                System.out.println("当前的线程是："+Thread.currentThread().getName()+"在创建文件:"+System.currentTimeMillis());
                long startTime = System.currentTimeMillis();
                //                FileUtils.touch(new File("E:\\"+Thread.currentThread().getName()+".txt"));
                long endTime = System.currentTimeMillis();
                System.out.println("创建文件耗时:"+(endTime-startTime)+":"+System.currentTimeMillis());
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("线程："+Thread.currentThread().getName()+"执行结束:"+System.currentTimeMillis());

        }
    }
}
