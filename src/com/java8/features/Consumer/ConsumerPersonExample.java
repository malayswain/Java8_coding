package com.java8.features.Consumer;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPersonExample {
    //creating as static consumer person type interface so that it can be used inside main method
    //this will accept the person dto and will print the entire data
    static Consumer<Person> c1 = (p) -> System.out.println(p);
    //we will retrive some information from person repository and modify it
    static Consumer<Person> c2 = (p) -> System.out.println(p.getName().toUpperCase());
    //to know the hobbies of the person
    static Consumer<Person> c3 = (p) -> System.out.println(p.getHobbies());
    //it will retrive all the student information and it will print each and every student information details the name and the hobbies
    //how we are going to iterate the list we will not use traditional for loop but we will use Java 8 for-each method

    //so that we can access in class level variable
    static List<Person> personList = PersonRepository.getAllPersons();
    public static void printNameandHobbies(){
        //iterates and prints all the persons
        personList.forEach(c1);
        //iterates and prints all the persons then makes there name to uppercase and print
        personList.forEach(c1.andThen(c2));
    }
    public static void printWithCondition(){
        //'p' in for-each will provide each and every student information everytime we will retrieve a student in p
        personList.forEach(p -> {
            //iterate student
            if(p.getGender().equals("Male") && p.getHeight() >= 140){
                c2.andThen(c3).accept(p);
            }
        });
    }
    public static void main(String[] args) {
        //List<Person> personList = PersonRepository.getAllPersons();
        c1.accept(PersonRepository.getPerson());
        c2.accept(PersonRepository.getPerson());
        c3.accept(PersonRepository.getPerson());
        c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());
        printNameandHobbies();
        printWithCondition();
    }
}
