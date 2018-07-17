package com.example.test.util;

/**
 * @Date:Created by luzy on 2018/7/16.
 * @Description:
 */
public class TestThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){;
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal testThreadLocal = new TestThreadLocal();

        testThreadLocal.set();
        System.out.println(testThreadLocal.getLong());
        System.out.println(testThreadLocal.getString());
        System.out.println("  ");
        Thread thread1 = new Thread(){
            public void run() {
                testThreadLocal.set();
                System.out.println(testThreadLocal.getLong());
                System.out.println(testThreadLocal.getString());
            };
        };

        thread1.start();
        thread1.join();
        System.out.println("  ");

        System.out.println(testThreadLocal.getLong());
        System.out.println(testThreadLocal.getString());
    }
}