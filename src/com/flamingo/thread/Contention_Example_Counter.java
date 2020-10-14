package com.flamingo.thread;

/**
 * 来自《深入理解Java虚拟机》周志明著
 * volatile变量自增运算测试
 *
 * @author zzm
 */
public class Contention_Example_Counter {
    //    public static int race = 0;
//    为什么使用volatile结果仍然不正确？
//    因为race++并不是一个原子操作
    public static volatile int race = 0;

    public static void increase() {
        race++;
        System.out.println(race);
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();

    }
}