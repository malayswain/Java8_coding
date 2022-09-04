package com.java8.features.Predicate;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPredicateExample {
    static Predicate<Person> pred1 = person -> person.getHeight() >= 140;
    static Predicate<Person> pred2 = person -> person.getGender().equals("Male");
    static BiPredicate<Integer, String> pred3 = (height, gender) -> height>=140 && gender.equals("Male");
    static BiConsumer<String, List<String>> hobbiesConsumer = (name,hobbies) -> System.out.println(name +" "+hobbies);
    static Consumer<Person> personConsumer = (per) -> {
//        if (pred1.and(pred2).test(per)){
//            hobbiesConsumer.accept(per.getName(), per.getHobbies());
//        }
        if(pred3.test(per.getHeight(), per.getGender())){
            hobbiesConsumer.accept(per.getName(), per.getHobbies());
        }
    };
    public static void main(String[] args) {
        List<Person> personList = PersonRepository.getAllPersons();
        personList.forEach(personConsumer);
    }
}
