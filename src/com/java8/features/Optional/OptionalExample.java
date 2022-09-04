package com.java8.features.Optional;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        //we are going to create a simple optional instance or a variable. Basically we are going to create a
        //simple method here which will echo my name
        //here we are going to use the optional to retrieve the value

        //what will happen if we straight away call the method and will show you what is the outcome of it
        System.out.println(myName("Malay"));
        //output - Malay but how we are going to improvise this particular method because what will happen if
        //it is return null how we are going to handle it because we dont want to put null check everytime right
        //so what we are going to do is i am going to use the optional

        //so based on the specified value it will return a normal value or empty optional
        //output - Optional[Milan] we will get optional with the data without using get()
        //if you want ot get the raw data use get() then output will be only Milan

        //Instead of keeping the output like Optional[Milan] we are going to retrieve as the optional variable
        //and it will return a string
        Optional<String> name = Optional.ofNullable(myName("Milan"));
        //String name1 = Optional.ofNullable(myName("Milan")).get();
        System.out.println(name.isPresent() ? name.get() : "No data found");
        //if you print this System.out.println(name); still you will get the output as Optional[Milan]
        //if you are trying to retrieve any data from an optional class or optional data which you retrieved
        //so what you need to do is we will use the get() method to get the raw data
        //so when you will send null value to name.get() it will give an exception i.e
        //java.util.NoSuchElementException: No value present so whenever you are using optional you cannot
        //straightforward go ahead and get the data before getting the data you need to make sure the data is
        //present so what we can do is so we have seen few methods under optional just go to optional
        //Let me use ispresent() which will return a boolean value which means whether the data is present or not
        //before printing the data by name.get() we will use ispresent() whether the name is present or not
        //if present then print the data other wise return any string of our choice
        //whichever place you have to do the null check make sure you are using optional because it has some
        //useful methods to help us avoid putting null check everywhere also we have another kind of method
        //ifpresent()

        System.out.println("=================================");
        System.out.println("Person name : " + personName(new Person()));
        //we will call the method which eventually return the not null data or null
        //there is confusion the object is not null but the person contains all variables/elements like
        //name,kids etc.. but these are all empty values or null values here
        //output is null we thought it will go for the else block and print "No data found" when we call the method
        //the problem is we check the person object is not null not the person that get name is not null.

        System.out.println("================================");
        //In the function arguments we need to send a person dto which is nothing but optional person
        //but if you go to the person repository we dont have a method which will return a optional person
        //so lets create one optional person in PersonRepository.
        Optional<String> personName = personNameWithOptional(PersonRepository.getPersonOptional());
        System.out.println("The Optional Person Name is : " + (personName.isPresent() ? personName.get() : "Data not found"));
        //when the optional.empty will return there are scenarios when you have the optional data is empty or
        //the data inside is empty we can check for ispresent() if ispresent() returns true then it has a proper
        //data then we return the data and if ispresent() returns false then we will return the optional.empty.
    }

    static String myName(String name) {
        return name;
        //what will happen if it is a null we will modify the code here and see
        //return null;
        //output - it will return (Optional.empty) to the calling method i.e Optional.ofNullable(myName("Milan"))
        //we have see that if is a ofnullable and the data is null it will return a empty optional
    }

    //we will create a new method which will return a person name from person repository and there we have a
    //method to retrieve a single person
    static String personName(Person person) {
        //traditional way not using optional example
        if (person != null) {
            return person.getName();
        } else {
            return "No data found";
        }
    }

    //Lets see the same above scenario in optional
    static Optional<String> personNameWithOptional(Optional<Person> person) {
        //here we are going to pass a optional person
        //now i am gonna check the condition here
        //first thing what we want gonna do is whether null
//        if(null!=person){
//            return person.map(Person::getName);
//            //the data is going to be empty because we are not passing any data to this method its just
//            //a skeleton for now. Here we are going to use the map method this is not the method which we
//            //used under the stream mapn this is the optional map which will help us to organize the object
//            //again like the class reference.
//            //We will retrieve the information from person dto remember its not the Person repository dto
//            // and getting the name and we will return that
//        }else {
//            //this is the place where optional is playing
//            //here we dont want to return a empty data so we have written optional.empty
//            return Optional.empty();
//
//            //we can slightly modify this code to make it even better because the optional example we used null check
//            //basically optional came for to replace the null check then why we use the null again
//            //here we will use the person.ispresent()
//        }
        if (person.isPresent()) {
            return person.map(Person::getName);
        } else {
            return Optional.empty();
        }
    }
}
