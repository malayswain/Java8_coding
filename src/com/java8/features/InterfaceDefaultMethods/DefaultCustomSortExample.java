package com.java8.features.InterfaceDefaultMethods;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Comparator;
import java.util.List;

//ALL ABOUT COMPARATOR FUNTIONAL INTERFACE
public class DefaultCustomSortExample {
    //now we will be creating comparator in the class level
    static Comparator<Person> c1 = Comparator.comparing(Person::getName);
    //this is another comparator which will sort the data based on person height
    static Comparator<Person> c2 = Comparator.comparingDouble(Person::getHeight);
    public static void main(String[] args) {
        //We want to sort all the persons based on the name
        //first step is to get list of persons
        List<Person> personList = PersonRepository.getAllPersons();
        //sortByName(personList);
        //sortByHeight(personList);

        //sortByHeightAndName(personList);
        //think about this scenario when the sort method is accepting a comparator but comparator can accept
        //multiple comparators how?
        //we can use thenComparing() method so we can use one comparator.thencomparing()
        //with this we can check multiple condition in a single statement so we can use multiple comparator
        //in the single sorting method

        sortByNameWithNull(personList);
        //we have a list of persons and also i do have a person with empty object for ex the person repo has
        //7 persons so i might have a null inbetween so how its going to work will that cause any issues lets see
        //so when we call this method sortByHeightAndName(personList); we will get null pointer exception
//        sorting by the height and name from person repository list
//        Exception in thread "main" java.lang.NullPointerException

        sortByNameWithNullLast(personList);
    }
    static void sortByName(List<Person> personList){
        //sort method takes comparator as a input either you can write a comparator here or we can write
        //the comparator in the class level and then you can use it
        //for now we will create the comparator here

        //sorting by the name
        System.out.println("sorting by the name from person repository list");
        //creating comparator in method level
        personList.sort(Comparator.comparing(Person::getName));
        personList.forEach(System.out::println);
    }
    static void sortByHeight(List<Person> personList){
        System.out.println("sorting by the height from person repository list");
        personList.sort(c2);
        personList.forEach(System.out::println);
        //when you are trying to compare the int, long or double values we have a separate method because its
        //a height so it basically double actually instead of comparing we can use comparing double
    }
    static void sortByHeightAndName(List<Person> personList){
        System.out.println("sorting by the height and name from person repository list");
        //both sorting will happen at at time
        personList.sort(c2.thenComparing(c1));
        personList.forEach(System.out::println);
    }
    static void sortByNameWithNull(List<Person> personList){
        //how are we going to handle the null pointer exception or have null checks
        //so in the comparator we have some additional methods to take care of the nulls also
        //there are two methods inside compartor we have two methods nullsfirst() and nullsLast()
        //nullsfirst() means if you have any null value that becomes the inital or first values
        //nullslast() means if you have any null value that becomes the last elements
        //in our repo the sixth element is the null value

        System.out.println("sorting by the name with null first from person repository list");
        //both sorting will happen at at time

        //first of all i need to have a comparator which will handle the nulls first
        Comparator<Person> nullcomp = Comparator.nullsFirst(c1);
        //we are going to sort the list and use null comparator as input
        personList.sort(nullcomp);
        personList.forEach(System.out::println);
        //now the null values will become the initial values by using nullsFirst

        //output - the null becomes the first value even though the null was in the middle it becomes the first
        //value thats the advantage of using nullsFirst()
    }
    static void sortByNameWithNullLast(List<Person> personList){


        System.out.println("sorting by the name with null last from person repository list");

        Comparator<Person> nullcomp = Comparator.nullsLast(c1);

        personList.sort(nullcomp);
        personList.forEach(System.out::println);

    }
}
