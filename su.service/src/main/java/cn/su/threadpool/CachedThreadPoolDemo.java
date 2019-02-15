package cn.su.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉;
 *  执行流程:
 *    1.请求进来，先查找线程池是否有空闲线程对象，如果有，则执行请求，如果没有则创建一个新的线程对象执行
 *    2.请求执行完，线程会维持默认1分钟的时间，如果1分钟内还有新的请求过来则执行新的请求，如果没有则自动销毁。
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CachedThreadPoolDemo {



    @Test
    public void test() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        TaskThread taskThread1 = new TaskThread();
        TaskThread taskThread2 = new TaskThread();
        TaskThread taskThread3 = new TaskThread();
        TaskThread taskThread4 = new TaskThread();
        long startTime = System.currentTimeMillis();
        System.out.println("进入taskThread1:"+System.currentTimeMillis());
        cachedThreadPool.execute(taskThread1);
        System.out.println("进入taskThread2:"+System.currentTimeMillis());
        cachedThreadPool.execute(taskThread2);
        System.out.println("进入taskThread3:"+System.currentTimeMillis());
        cachedThreadPool.execute(taskThread3);
        System.out.println("进入taskThread4:"+System.currentTimeMillis());
        cachedThreadPool.execute(taskThread4);
        long endTime = System.currentTimeMillis();
        System.out.println("执行4个线程调度时间为："+(endTime-startTime));
        try{
            Thread.sleep(4000L);
        }catch(Exception e){e.printStackTrace();}


    }

    private class TaskThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前是线程："+Thread.currentThread().getName()+"在执行:"+System.currentTimeMillis());
            try{
//                Thread.sleep(1000L);
                System.out.println("当前是线程："+Thread.currentThread().getName()+"在创建文件:"+System.currentTimeMillis());
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
