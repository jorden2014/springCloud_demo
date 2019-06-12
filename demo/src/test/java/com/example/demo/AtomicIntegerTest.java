package com.example.demo;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: jorden
 * @Date: 2019/1/22 16:53
 * @Description:
 */
public class AtomicIntegerTest {
    public static final int THREAD_COUNT = 200;

    public static int count = 0;
//    public static volatile int count = 0;
//    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase(){
        count++;
//        count.incrementAndGet();
    }

    @Test
    public void test1(){
        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i = 0;i<THREAD_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        /*while (Thread.activeCount() > 1){
            Thread.yield();
        }*/
        System.out.println(count);
    }
}
