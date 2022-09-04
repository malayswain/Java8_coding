package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Comparator;

public class StreamCustomSortExample {
    public static void main(String[] args) {
        System.out.println("Sort by name");
        //First we need to retrieve the list of person information which is available in the person repository
        //Since its returning the list we can directly use the stream here
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                //if we were to handle the same scenario in the traditional way we need to write the custom comparator
                //and we need to create our own logics into that and then we need to apply the comparator here.
                //but here everything is simplified.
        .forEach(System.out::println);//when we look for sort inside stream we will find two types of method 1. is sorted() i.e normal one
        //second one sorted method which takes comparator as a input in the comparator we can provide our own type
        //of filter data means which element we need to sort based on it and we will use the second sorted method
        //inside comparator method we need to specify which parameter we gonna use to sort that
        //so we need to retrieve it from person DTO
        //From person repository we are streaming the data and sorting it based on the getname
        //so we can directly print the data here
        //output - data is sorted based on the name

        //CUSTOM SORTING BY HEIGHT
        System.out.println("===================================");
        System.out.println("Sort by height");
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(System.out::println);

        //Scenarios when we have to sort in reverse order like sorting person names in reverse order or descending
        //order
        System.out.println("===================================");
        System.out.println("Sort by name reverse order");
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getName).reversed())//once the comparator is defined here
                //if you want to use the descending order just use the method called as reverse() inside the
                //Comparator
                .forEach(System.out::println);
        //This is one of the most important advantage of using the functional programming in Java8
        //so for we are transforming the data and processing it.
    }
}
