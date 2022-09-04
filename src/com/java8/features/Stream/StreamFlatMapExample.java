package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    // we want to take out all the hobbies as a single list and also we will filter what kind of distinct hobbies
    //we have and we will do that using a flatmap()
    static List<String> hobbies(List<Person> personList){
        return personList.stream()//list of person in the stream
                .map(Person ::getHobbies)//we are not going to directly flattened the data the first thing we have to retrieve the
        //hobbies which is nothing but a list of data inside my person first we will retrieve the data then we
        //will convert into a flat map and now we have got the hobbies and now we will transform into a flatmap()
                //here from stream we are retrieving the list of persons and inside persons we have hobbies
                //so here we have list of hobbies
        .flatMap(List :: stream)//flatmap comes under List//that particular list of data is here converting them into
                //a stream
                //there is stream method inside List impl class which Returns a
                // possibly parallel Stream with this collection as its source.
                // here inside flatmap list is the hobbies list and therefore we are converting them into stream
                //once the data is added to the stream we can collect the data
                //here we are converting list of hobbies into a flat map which is nothing but put all the hobbies
                //inside a single list so gethobbies which is nothing but a list of data
        .collect(Collectors.toList()); //once the data convert into a stream we can collect them using collect method
        //then using collectors we can retrieve tolist or toset etc..
    }
    //creating a method that will return distinct hobbies or no duplicates
    static List<String> distinctHobbies(List<Person> personList){
        return personList.stream()
                .map(Person ::getHobbies)
                .flatMap(List :: stream)//once the data is flattened then you can use the another method called distinct
                //flattened the data
                .sorted()//once the data gets flattened we can use the method called sorted() which will take care of
                //sorting or sorted the data and it will do the normal sorting.
                .distinct()//it will help to remove the duplicate values or removing the duplications
                .collect(Collectors.toList());//lastly collect them as a list
    }
    //when we have numerous numbers of hobbies and we want to know how many total hobbies which we are
    //referring so far in our system so we can use the count method to get those information
    static long countOfHobbies(List<Person> personList){
        return personList.stream()
                .map(Person::getHobbies)//before we directly use the flatmap we need to collect the map first because the map will
        //retrieve the list of hobbies
        .flatMap(List::stream)//once the data is pulled into stream in flatmap we can use the distinct
                .distinct()
                .count();//we dont need to collectas a collection because we are going to return only the
        //primary datatype. so we use the count method which will return the total count
    }
    public static void main(String[] args) {
        //we can have two different kind of list one is odd number and another is even number list
        //we are going to flatten those results into a single
        List<Integer> oddnumbers = Arrays.asList(1,3,5,7);
        List<Integer> evennumbers = Arrays.asList(2,4,6,8);
        //we are going to combine it as a single list
        List<List<Integer>> listOflist = Arrays.asList(oddnumbers,evennumbers);
        System.out.println("before flattening "+listOflist);//output - [[1, 3, 5, 7], [2, 4, 6, 8]]
        //this is how the data looks like before flattening
        //flatmap() will return all these elements - [[1, 3, 5, 7], [2, 4, 6, 8]] into a single list
        //thats why its called a flattened list
        List<Integer> flattenedList = listOflist.//list of combined data
                stream().
                flatMap(list -> list.stream())//we are going to flattened the data here
        //inside flat we are converting the list of integer into a list of stream
        .collect(Collectors.toList());//here we will collect them into a list
        System.out.println("===================================");
        System.out.println("after flattening "+flattenedList);
        //before flattened we have list and inside list we have two results or two lists
        //and this is not a flattened data
        //but take a look at after flattening result - [1, 3, 5, 7, 2, 4, 6, 8] all of them flattened into a
        //single list. so these scenarios we can use flatmap
        System.out.println("======================");
        System.out.println("All hobbies with duplicates "+hobbies(PersonRepository.getAllPersons()));
        System.out.println("===================================");
        System.out.println("All hobbies without duplicates "+distinctHobbies(PersonRepository.getAllPersons()));
        System.out.println("===============================");
        System.out.println("Hobbies count " + countOfHobbies(PersonRepository.getAllPersons()));
    }
}
