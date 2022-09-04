package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {
    static Predicate<Person> p1 = s -> s.getHeight()>140;
    static Predicate<Person> p2 = s -> s.getGender().equals("Male");
    public static void main(String[] args) {
        //we want to know the number of kids means total kids means if i have a six persons here
        //when we call it should return total number of kids
        int kidscount = PersonRepository.getAllPersons()//gives the list of persons which are there in person repo
        .stream()
                .filter(p1.and(p2))//let me do some filter we will filter persons having height >140 and gender is male
                .map(Person::getKids)//get the kids for each and every person
        .reduce(0, (x,y) -> (x+y));//we can use this way also
                //.reduce(0, Integer::sum);//we know that reduce is apply some functionality it will apply to the entire function
        //to all the elements which is there in the list
        //lets have the initial value because we are going to sum the number of kids so initial value is to be zero
        //we can use the Integer class because sum is under the Integer
        //it will return the data as integer.
        System.out.println("Number of kids " + kidscount);
    }
}
