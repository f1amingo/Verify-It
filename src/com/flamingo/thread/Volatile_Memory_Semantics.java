package com.flamingo.thread;

public class Volatile_Memory_Semantics {

    //    JDK5之后 volatile的获得与锁相同的内存语义
    static class Volatile_Happens_Before {
        int a = 0;
        volatile boolean flag = false;

        public void writer() {
            a = 1;
            flag = true;
        }

        public void reader() {
            if (flag) {
                int i = a;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Volatile_Happens_Before instance = new Volatile_Happens_Before();
        new Thread(instance::writer).start();
        new Thread(instance::reader).start();
    }

}
