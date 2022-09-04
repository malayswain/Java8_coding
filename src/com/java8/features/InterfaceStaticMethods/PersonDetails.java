package com.java8.features.InterfaceStaticMethods;

import com.java8.features.Repo.Person;

import java.util.List;
import java.util.stream.Collectors;

public interface PersonDetails {
    //before java8
    //we are having seven to eight persons we are trying to calculate the total salary for all the persons
    //for each and every month
    double calculateTotalSalary(List<Person> person);
    //we will have a implementation class which will implement the particular interface

    //lets try to implement the java8 funtionality like default method
    default int totalkids(List<Person> personList){
        //it will give us total kids count
        return personList.stream().map(Person::getKids).reduce(0,(x,y)->x+y);
        //but normally in previous versions if you add a new method in an interface wherever the interface
        //implemented you need to provide the implementation but since its a default method we dont have to
        //because this is a method which implements that personal detail right

        //this body impl in interface was never there before its introduced in java8
    }
    //lets have a static method which will return list of string the string contains the name of the person's
    static List<String> personNames(List<Person> personList){
        return personList.stream().map(Person::getName).collect(Collectors.toList());
    }

    //both static and default looks similar what another important thing about it
    //the static method we cannot override the reason is static method is called using the class names
    //so we might think what will happen if i do
    // but we can override the default method
}
