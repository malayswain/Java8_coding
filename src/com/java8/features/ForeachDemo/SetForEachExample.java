package com.java8.features.ForeachDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetForEachExample {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("Ramesh", 29));
        set.add(new Person("Tony", 50));
        set.add(new Person("Tom", 45));
        set.add(new Person("John", 55));

        //for-each loop with lamdba
        set.forEach((person) -> {
            System.out.println(person.getAge());
        });
    }
}
