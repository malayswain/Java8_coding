package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterExample {
    static Predicate<Person> p1 = s -> s.getHeight()>140;
    static Predicate<Person> p2 = s -> s.getGender().equals("Male");
    public static void main(String[] args) {
        //Filter() is helpful in controlling the data. Filter() helps in restricting the dataflow or put some
        //condition over it and then return the data
        List<String> names = Arrays.asList("Sam", "Ander", "Peter", "Nancy");//list of strings
        //we need the names whoever has the length more then three or four words
        //creating stream of strings
        Stream<String> allNames = names.stream();//using the list and creating stream
        //This above one contains all the names
        //we are converting it into a stream
        Stream<String> updatedList = allNames.filter(s -> s.length()>=3);//we will check the condition now
        //updatedList contains names which is greater than 3
        //now we will print the data
        //we are creating another list(updatedList) to store the updated value and then i am printing it.
        updatedList.forEach(System.out::println);
        //The filter functionality will help us to restrict the data which data we need to consider and which data
        //we need to omit
        //so we can do the above processes in a single line
        System.out.println("==============================");
        // whatever we did above below code we did it in a single line
        //here we are not creating any new list
        names.stream().filter(s -> s.length()>3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("================================");
        PersonRepository.getAllPersons()
                .stream()
                .filter(s -> s.getHeight()>140)//Filter always expect the predicate as a parameter
                //we can also create a predicate and directly pass it here
                //we can use as many filters we want
                .filter(s -> s.getGender().equals("Male"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //we can also retrieve all the information as a list then we can extract the list and see the data
        //or we can directly also do that or the below one is also a way to do it
        /*List<Person> l1 = PersonRepository.getAllPersons()
                .stream()
                .filter(s -> s.getHeight()>140)
                .collect(Collectors.toList());
                l1.forEach(System.out::println);*/
        System.out.println("========================== use of predicate ===================");
        PersonRepository.getAllPersons()
                .stream()
                .filter(p1)
                .filter(p2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("========================== use of predicate methods ===================");
        PersonRepository.getAllPersons()
                .stream()
                .filter(p1.and(p2))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
