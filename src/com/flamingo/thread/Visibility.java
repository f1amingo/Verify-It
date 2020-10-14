package com.flamingo.thread;

/**
 * 知识点：Java内存模型
 */
public class Visibility {
    //    static volatile boolean running = true;
    static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (running) {

            }
            System.out.println("Child thread finished.");
        }).start();
//        sleep the main thread to make sure child thread run first.
        Thread.sleep(100);
//        the child thread doesn't notice the value change.
        running = false;
        System.out.println("Main thread finished.");
    }
}
