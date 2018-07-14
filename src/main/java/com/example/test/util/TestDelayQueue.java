package com.example.test.util;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Date:Created by luzy on 2018/6/28.
 * @Description:
 */
public class TestDelayQueue {
    public static void main(String[] args) throws InterruptedException {


        DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();

        DelayedEle element1 = new DelayedEle(3000,"zlx");
        DelayedEle element2 = new DelayedEle(2000,"gh");

        delayQueue.offer(element1);
        delayQueue.offer(element2);

        while (true){
            element1 =  delayQueue.take();
            System.out.println(element1);
        }


    }


}

class DelayedEle implements Delayed {

    private final long delayTime; //延迟时间
    private final long expire;  //到期时间
    private String data;   //数据

    public DelayedEle(long delay, String data) {
        delayTime = delay;
        this.data = data;
        expire = System.currentTimeMillis() + delay;
    }

    /**
     * 剩余时间=到期时间-当前时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    /**
     * 优先队列里面优先级规则
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delayTime);
        sb.append(", expire=").append(expire);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
