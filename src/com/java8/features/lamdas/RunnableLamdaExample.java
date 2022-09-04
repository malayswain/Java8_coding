package com.java8.features.lamdas;

public class RunnableLamdaExample {
    public static void main(String[] args) {
        //before java 8
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 running");
            }
        };
        new Thread(t1).start();
        //after java 8 by lamda expression
        Runnable t2 = () -> {System.out.println("Thread 2 running");};
        new Thread(t2).start();
        Runnable t3 = () -> {
            System.out.println("Thread 3 running");
            System.out.println("Thread 3.1 running");
        };
        new Thread(t3).start();
        //before java 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 4 running");
            }
        }).start();
        //after java 8
        new Thread(() -> {
            System.out.println("Thread 5 is running");
        }).start();
    }
}
