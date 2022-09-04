package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7vsJava8Example2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam","Peter","Billings","Sam");
        //before java 8
        List<String> uniquelist = new ArrayList<>();
        for(String name:names){
            if(!uniquelist.contains(name)){
                uniquelist.add(name);
            }
        }
        System.out.println("unique list 1 " + uniquelist);
        //after java 8
        List<String> uniqueList2 = names.stream().distinct().collect(Collectors.toList());
        System.out.println("unique list 2 " + uniqueList2);
    }
}
