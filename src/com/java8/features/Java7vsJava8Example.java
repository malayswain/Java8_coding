package com.java8.features;

import java.util.stream.IntStream;

public class Java7vsJava8Example {
    public static void main(String[] args) {
        //before java 8
        int total = 0;
        for(int i = 0; i <=50; i++){
            total += i;
        }
        System.out.println("total is " + total);
        //after java 8
        int total1 = IntStream.rangeClosed(0,50).map(Integer :: new).sum();
        System.out.println("total1 is " + total1);
    }
}
