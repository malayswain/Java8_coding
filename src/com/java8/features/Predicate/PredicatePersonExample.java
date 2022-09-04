package com.java8.features.Predicate;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePersonExample {
    static Predicate<Person> pred1 = person -> person.getHeight() >= 140;
    static Predicate<Person> pred2 = person -> person.getGender().equals("Male");
    public static void main(String[] args) {
//        List<Person> personList = PersonRepository.getAllPersons();
//        personList.stream().filter(pred1).collect(Collectors.toList());
//        personList.forEach(per -> {
//            if(pred1.test(per)){
//                System.out.println(per);
//            }
//        });
        List<Person> personList1 = PersonRepository.getAllPersons();
        personList1.stream().filter(pred2).collect(Collectors.toList());
        personList1.forEach(per -> {
            if(pred2.test(per)){
                System.out.println(per);
            }
            if (pred1.and(pred2).test(per)){
                System.out.println(per);
            }
        });
    }
}
