package com.java8.features.lamdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        //before java 8
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Comparator value for the comparision " + c1.compare(15,25));
        //after java 8
        Comparator<Integer> c2 = (Integer x, Integer y) -> x.compareTo(y);
        System.out.println("Comparator value for the comparision by lambda " + c2.compare(15,5));
        Comparator<Integer> c3 = (x,y) -> x.compareTo(y);
        System.out.println("Comparator value for the comparision by lambda 2nd way " + c3.compare(15,15));
    }
}
