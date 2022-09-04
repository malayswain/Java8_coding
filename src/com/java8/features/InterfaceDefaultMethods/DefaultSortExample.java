package com.java8.features.InterfaceDefaultMethods;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSortExample {
    public static void main(String[] args) {

        //before java8
        //In our person repository we have list of persons what i want to do is i want to retrieve all the names
        //from the list of persons and then i want to sort them with the help of collection.sort()
        List<String> namList = PersonRepository.getAllPersons()
                .stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("Before sort");
        namList.forEach(System.out::println);

        //now we are going to sort the list
        System.out.println("After sort");
        Collections.sort(namList);
        //Collections.sort is nothing but our traditional model which we are running/using before java 8
        namList.forEach(System.out::println);

        System.out.println("==============================================");
        //after java8
        //The one which we will try now its a different way these are introduced as part of java8
        //one of the method i.e introduced in java8 is the sort() which will accept a comparator
        //we are not going to use the comparing here because under comparator we have different types
        //of method like comparing Int,comparing Long, comparing Double etc.. but there are some additional methods
        //natural order() method and reverse order() method, natural order means by defaults
        // it will sort the data in a ascending format
        //and reverse order the opposite it will sort the data on the descending order lets see

        //we are going to use the natural order() method here
        System.out.println("Natural order sort");
        namList.sort(Comparator.naturalOrder());
        namList.forEach(System.out::println);
        //output it prints the data in ascending order

        System.out.println("===============================================");

        //we are going to use the reverse order() method here
        System.out.println("Reverse order sort");
        namList.sort(Comparator.reverseOrder());
        namList.forEach(System.out::println);
        //output it prints the data in descending order
    }
}
