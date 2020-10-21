package com.flamingo;


public class Main {

    static class State {
        int a = 0;
        boolean flag = false;
    }

    public static void main(String[] args) {
        for (; ; ) {
            final State state = new State();
            new Thread(() -> {
                state.a = 1;
                state.flag = true;
            }).start();
            new Thread(() -> {
                int tmpA = state.a;
                if (state.flag) {
                    if (tmpA == 0) {
                        System.out.println("wtf!!!");
                    }
                }
            }).start();
        }
    }

//    int a = 0;
//    boolean flag = false;
//
//    public void writer() {
//        a = 1;
//        flag = true;
//    }
//
//    public void reader() {
//        if (flag) {
//            if (a == 0) {
//                System.out.println("wtf!!!");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        while (true) {
//            Main instance = new Main();
//            new Thread(instance::writer).start();
//            new Thread(instance::reader).start();
//        }
//    }
}
