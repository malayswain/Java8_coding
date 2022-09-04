package com.java8.features.InterfaceStaticMethods;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;

public class PersonDetailClient {
    static  List<Person> personList = PersonRepository.getAllPersons();
    public static void main(String[] args) {
        //it will call the PersonDetailImpl from here
        PersonDetails personDetails = new PersonDetailImpl();
        System.out.println("Total Salary "+ personDetails.calculateTotalSalary(personList));
        System.out.println("Total kids "+ personDetails.totalkids(personList));


        //static method can be called by obj personlist
        PersonDetails.personNames(personList).forEach(System.out::println);
        //so here i used this particular person detail and i call this particular person names
        //this will always invoke the method under the person detail interface but this will never
        //invoke persondetailimpl static maethod with same name

        //so if you want the impl class static method then
        System.out.println("static method from Person detail impl");
        PersonDetailImpl.personNames(personList).forEach(System.out::println);
    }
}