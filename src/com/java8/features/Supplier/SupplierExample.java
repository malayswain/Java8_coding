package com.java8.features.Supplier;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Person> personSupplier = () -> PersonRepository.getPerson();
    static Supplier<List<Person>> personSupplier2 = () -> PersonRepository.getAllPersons();
    public static void main(String[] args) {
        //so far we are doing this to get the list of persons
        //List<Person> personList = PersonRepository.getAllPersons();
        //System.out.println("Result " + personSupplier.get());
        System.out.println("Result :" + personSupplier2.get());
    }
}
