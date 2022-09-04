package com.java8.features.ForeachDemo;

import java.util.HashMap;
import java.util.Map;

public class MapForEachExample {
    public static void main(String[] args) {
        //key as integer and value as Person object
        Map<Integer, Person> map  = new HashMap<Integer, Person>();
        map.put(1, new Person("Malay", 29));
        map.put(2, new Person("Shree", 9));
        // prior to java 8 we use foreach loop to iterate over the map
//        for(Map.Entry<Integer, Person> entry:map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue().getName());
//        }
        //for-each with lambda
        map.forEach((k,v) ->{
            System.out.println(k);
            System.out.println(v.getName());
            System.out.println(v.getAge());
        });
    }
}
