package com.example.test.util;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date:Created by luzy on 2018/5/30.
 * @Description:
 */
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 6; i++) {
            System.out.println("添加第"+i+"个任务");
            try {
                executor.execute(new MyThread("线程"+i));
            }catch (RejectedExecutionException E){
                System.out.println("拒绝异常");
            }

            Iterator iterator = executor.getQueue().iterator();
            while (iterator.hasNext()){
                MyThread thread = (MyThread) iterator.next();
                System.out.println("列表："+thread.name);
            }
        }
    }


}

class MyThread implements Runnable {
    String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+name +"  run");
    }
}
