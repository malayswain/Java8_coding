package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsCollectionExample {
    public static void main(String[] args) {
        //create a simple arraylist and iterate over it
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Goli");
        names.add("Rolly");
        //traditional way of iterating data with the help of iterator
        //we will use the for method and iterate each and every elements
        //we need to create a for loop and we need to use an external iterator
        //so it will iterate each and every element and print the element
        //if its a collection we can iterate 'n' number of times
        for (String name : names){
            System.out.println(">>> Iteration 1 :" + name);
        }
        for (String name : names){
            System.out.println(">>> Iteration 2 :" + name);
        }
        System.out.println("=======================================");
        //lets create a stream of names and we will see how we are going to iterate them
        //we are going to create a stream of names
        //we acn use Stream.of method or we alresdy have a list just convert it to stream
        // by adding name.stream() we converted the list to stream of string data and its ready
        //its going to use an internal iterator operation the method is for-each()
        //we have internal iterator foreach() and always internal method is faster
         Stream<String> stream = names.stream();
        stream.forEach(p -> System.out.println(">>> " + p));
        //let us try to iterate the data in stream again
        //stream.forEach(p -> System.out.println(">>> " + p)); --> not possible to iterate again
        //if we try to iterate the stream one more time then it will throw an exception java.lang.IllegalStateException
        //stream has already been operated upon or a closed stream
        //once the stream is opened and its processed that means we cannot use the stream again so it can be used only once

        //we can debug streams in a easier way there is some method called peak() under the stream we can use the
        //peak method which will help us to show the data means all the details about the data which is handling
        //by the particular iterator
        System.out.println("=========================================");
        List<String> personList = PersonRepository.getAllPersons().
                stream().
                peek(person -> System.out.println(person)).//whenever it streams the person i want to print the data
                //so once the stream is opened i am going to use the peak method
                        //peak will accept a consumer
                map(Person::getName).//map() is used to transform the data
        //data we are trying to retrieve is getname() from the person
        //we will use a method reference
                peek(System.out::println).
        collect(Collectors.toList());//then we will collect them as a list
        //we have the personlist but we havenot printed yet and not used any sysout for personlist
        //what is happening is whenever you peek() a debug element we also print single type like only hobbies,
        //or only name etc.. any explanation you give inside the peek will be operated
        //like filter we can also use multiple peeks
        //once the data is converted into stream of strings we will do a peek to see what are the names inside in it
        //we get all information from first peek
        // Person{name='Hulu', height=164, salary=2005.0, gender='FeMale', kids=2, hobbies=[Painting, Cooking, Singing]}
        // and second peek Hulu
        //when you are working with lot of data if you want to know what are the data passing to each and every
        //steps you can use the peak to know the data
    }
}
