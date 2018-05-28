package com.example.test.util;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Date:Created by luzy on 2018/5/28.
 * @Description: 延时队列
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
        queue.add(new DelayTask("2", 2000L, TimeUnit.MILLISECONDS));
        queue.add(new DelayTask("3", 3000L, TimeUnit.MILLISECONDS));

        System.out.println("queue put done");

        while(!queue.isEmpty()) {
            try {
                DelayTask task = queue.take();
                if("1".equals(task.name)){
                    /*task.name="12";
                    task.delayTime=55000L;
                    task.delayTimeUnit=TimeUnit.MILLISECONDS;*/
                    queue.add(new DelayTask("4", 9000L, TimeUnit.MILLISECONDS));
                 //   queue.add(task);
                    continue;
                }
                System.out.println(task.name + ":" + System.currentTimeMillis()+ ": "+new Date(System.currentTimeMillis()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DelayTask implements Delayed {
    public String name;
    public Long delayTime;
    public TimeUnit delayTimeUnit;
    public Long executeTime;//ms

    DelayTask(String name, long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }


    @Override
    public int compareTo(Delayed o) {
        if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }else if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

}
