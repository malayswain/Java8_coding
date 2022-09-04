package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {
    public static void main(String[] args) {
//        //creating stream using stream implementation methods
//        Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
//        s1.forEach(p -> System.out.println(p));
//        System.out.println("------------------------");
//        //creating stream with help of arrays
//        Stream<Integer> s2 = Stream.of(new Integer[] {9,8,7,6,5,4});
//        s2.forEach(p -> System.out.println(p));
        // to get all student information and out of it we need to get a map which will contain a name and hobbies of the person
        //List of string which will hold the hobbies
        //first we are fetching list of persons from person repository
        //now i have all the person information i have to iterate them with the help of stream
        //then filter out the specific person information.
        //we will use the collect method which will help us to transform one kind of data to another kind of data.
        //now we have list of persons we will retrieve specific information and put in the map
        //for this we will use collectors under we have lot of types available like tolist, tomap
        //if we are using map then we have to provide key and value pair
        //here key is the studentname we will be using method reference and value is going to be the hobbies
        Map<String, List<String>> perMap = PersonRepository.getAllPersons().//iterate all persons
                stream().//stream of persons
                collect(Collectors.toMap(Person :: getName,Person :: getHobbies));//each and every stream of person
        // will be collected as a map and everything put together into a single map and return back to us as a person map
        System.out.println("person map :" + perMap);
        //The above code will help us to transform one kind of data to another kind of data
        //but in traditional way of programming this is not this much easier we need to create a for loop inside the
        //for loop we need to put all the conditions

        //we can do any kind of filtering operation with the streams
        //like we want to retrieve specific person information like the person who has the height more than 140
        System.out.println("==============================================");
        Predicate<Person> p1 = per -> per.getHeight() >=140;
        //how we are going to filter the particular information from this particular map
        //before we have collected all the person information and we have created a stream of persons
        //and we collected all of them into a map
        //but before collecting the data we can filter the data we can filter the data
        //we can use a method filter which will accept a predicate
        //we have created the predicate just pass the predicate to the filter method thats all
        Map<String, List<String>> perMap1 = PersonRepository.getAllPersons().//iterate all persons
                stream().//stream of persons
                filter(p1).
                collect(Collectors.toMap(Person :: getName,Person :: getHobbies));
        System.out.println(perMap1);
        System.out.println("==============================================");
        //we can do multiple filters also
        //we can put both the predicates into a single Bi-predicate also
        Predicate<Person> p2 = per -> per.getGender().equals("Male");
        Map<String, List<String>> perMap2 = PersonRepository.getAllPersons().//iterate all persons
                stream().
                filter(p1).
                filter(p2).
                collect(Collectors.toMap(Person :: getName,Person :: getHobbies));
        System.out.println(perMap2);
        System.out.println("==============================================");
        //lets take out the hobbies of each and every person the outcome will be list of strings
        //the map we are using is not a hash map its a map its used for transforming one kind of data
        //to another kind of data. this map is not same as collections map
        //the error came because we are trying to get the information from a list.
        //inside person class hobbies is already a list you can open the person and see
        //using the flat map the error got resolved
        List<String> personhobbies = PersonRepository.getAllPersons().//List of Persons
                stream().//Stream of persons
                map(Person :: getHobbies).//transformation part here it will not come as direct list of string
                //it will come as stream of data Stream<List<String>> -> this is how it will come
                flatMap(List::stream).//then we are converting this stream into a flat stream
                //here it will be a stream of strings like Stream<String>
                collect(Collectors.toList());//final conversion part which kind of data what collection
                //we need to return which collection to be returned
        System.out.println(personhobbies);
        System.out.println("==============================================");
        //in the output if we have noticed there is lot of duplicate values because each and every person has
        //different kind of hobbies but some of them have same hobbies like two persons can have tennis as same hobby
        //we can try to achieve list of unique hobbies
        List<String> personhobbies2 = PersonRepository.getAllPersons().//List of Persons
                stream().//Stream of persons
                map(Person :: getHobbies).
                        flatMap(List::stream).
                        distinct().//we can use here filter() but similar to it we have predefined distinct()
                //which is available called has a distinct method so once the data is transformed we can use the
                        //distinct method to see the unique outcome or duplication will be removed
                        collect(Collectors.toList());
        System.out.println(personhobbies2);
    }
}
