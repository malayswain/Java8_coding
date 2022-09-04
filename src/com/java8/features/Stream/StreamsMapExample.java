package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {
    static List<String> toUpperTransform(List<Person> personList){
        //we are creating static method because we will call this method from main method which is also a static method/scope
        //we will use our map to transform the data into a different kind of data
        //here we have list of persons we will process all of them and return list of strings which contain the
        //person names with capital letter
        //here we have converted list of persons to list of strings
        return personList.stream()//list of stream
                .map(Person::getName)//we will retrieve the name from the person//stream of person
                .map(String::toUpperCase)//we will use another map which will convert the data to the uppercase
                //here its is stream of strings
                .collect(Collectors.toList());//here we collect the data as a list
    }
    static Set<String> toUpperTransformset(List<Person> personList){
        //here we have converted set of persons to set of strings
        return personList.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }
    public static void main(String[] args) {
        //map is used for converting one type of data to another type of data
        //creating a list of string
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");
        //we will use map against this particular list and retrieving list of integers
        //list of integers is nothing but length of each and every fruit
        //APPROPIATE WAY
        List<Integer> fruitlength = fruits.stream()//under stream we have a method called as map
                .map(String :: length)//map will take a Function Functional Interface as a parameter
        //we will take the length() of each and every string by method reference
                //here we have the transformation from list of strings to list of integers
                //now we can collect the trsnformed list with help of collect() method
        .collect(Collectors.toList());//so which kind of data we need inside collect we will use collectors
        //collectors contains all kinds of data in this case we want it to collect as a list so we use tolist()
        //if you want to know what inside collector just press ctrl and click to open the decompile
        System.out.println(fruitlength);
        System.out.println("===================");
        System.out.println("alternative way");
        fruits.stream()
                .map(String :: length)
                .collect(Collectors.toList())
                .forEach(System.out::println);//its a list data so we can use foreach and inside it we can use
                //method reference to print the elements and foreach method used to print the data
        System.out.println("===========================");
        System.out.println("to uppercase "+ toUpperTransform(PersonRepository.getAllPersons()));
        //input we need to pass person list which is available in person repository
        System.out.println("===========================");
        System.out.println("to uppercase set result"+ toUpperTransformset(PersonRepository.getAllPersons()));
    }
}
