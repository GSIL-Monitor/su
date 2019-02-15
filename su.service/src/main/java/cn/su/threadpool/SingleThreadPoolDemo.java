package cn.su.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉;
 *  执行流程; 1.一个请求过来
 *           2.看看线程池是否有空闲的线程
 *           3.如果有就执行请求
 *           4.如果没有就等待，直到上一个线程执行完
 *           ps.类似于下面的测试类，第一个线程进来，发现有空闲线程，开始执行创建文件的任务，但是并不会等创建完文件才执行
 *           下一个任务，这是一个异步的过程，直接执行下一个请求，但是发现没有空闲的线程，于是返回等待，然后执行第三个线程，
 *           发现还是没有空闲的线程，继续等待，执行下一个线程，以此类推。。。所以结果就是等四个线程都执行了一遍，还是没有
 *           空闲的线程，因为JVM已经销毁了，最终只有一个任务在执行。但是如果保持JVM为守护线程的话，四个线程最后都会执行的
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SingleThreadPoolDemo {

    @Test
    public void test() throws Exception{
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        TaskThread taskThread1 = new TaskThread();
        TaskThread taskThread2 = new TaskThread();
        TaskThread taskThread3 = new TaskThread();
        TaskThread taskThread4 = new TaskThread();
        long startTime = System.currentTimeMillis();
        singleThreadExecutor.execute(taskThread1);
        singleThreadExecutor.execute(taskThread2);
        singleThreadExecutor.execute(taskThread3);
        Thread.sleep(1L);
        singleThreadExecutor.execute(taskThread4);
        long endTime = System.currentTimeMillis();
        System.out.println("执行4个线程调度时间为："+(endTime-startTime));

    }
    private class TaskThread implements Runnable{

        @Override
        public void run() {
            System.out.println("当前是线程："+Thread.currentThread().getName()+"在执行");
            try{
                System.out.println("当前是线程："+Thread.currentThread().getName()+"在创建文件");
//                FileUtils.touch(new File("E:\\"+Thread.currentThread().getName()+".txt"));
                Thread.sleep(1L);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("线程："+Thread.currentThread().getName()+"执行结束");

        }
    }
}
