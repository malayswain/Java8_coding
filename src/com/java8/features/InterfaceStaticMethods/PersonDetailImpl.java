package com.java8.features.InterfaceStaticMethods;

import com.java8.features.Repo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDetailImpl implements PersonDetails {
    //we can see that we are not getting any error even though a default method is defined in interface
    // which the class is extending we dont have to override it thats the advantage of default method in
    //interface

    //we have defined a static method in the interface still we are not getting any exception
    //because thats not a issue here because the static method we dont have to provide any implementation here

    @Override
    public double calculateTotalSalary(List<Person> person) {
        //we need to override the methods present in interface.
        return person.stream().map(Person::getSalary).reduce(0.0d,(x,y) -> x+y);
        //it is giving error because salary is double but interface is int
    }
    @Override
    public int totalkids(List<Person> personList) {
        //it will give us total kids count
        return 20+20;
        //if we get the result as 40 so we will know that this implemetation has been called
        //not the default impl in the interface because overrriden always happen in the child class
        //the Persondetails interface is a parent so child always overrides the method that has a higher
        //priority
    }
    //there is no error because this particular method belong to personimpl
    //to check its not overriden we will send some random things to test
    static List<String> personNames(List<Person> personList){
        //return Arrays.asList("1,3,4,5,6");
        return personList.stream().map(Person::getName).collect(Collectors.toList());
    }
}
