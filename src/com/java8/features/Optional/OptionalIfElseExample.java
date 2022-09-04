package com.java8.features.Optional;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Optional;

public class OptionalIfElseExample {
    public static void main(String[] args) {
        //we are going to retrieve a person name from our person repository and then we are getting the name from
        //person dto
        orElse();
        orElseGet();
        orElseThrow();
    }
    static void orElse(){
        Optional<Person> person = PersonRepository.getPersonOptional();//here we will get john as the object
        //here i am retrieving the name

        String name = person.isPresent()?person.get().getName():"Name not found";
        //ispresent will return a boolean true or false if true we will print the person
        //we have the person object from person repository so we can get the name from it
        System.out.println("OrElse Person Name : " + name);

        //example of ifpresent() and orElse()
        String name1 = person.map(Person::getName)//map will help us to get name and checking
                // whether the person name is available or not if name available then okay otherwise else part
        .orElse("No data found");//so what will happen if the person is not available then what you need to do so here the
        //else part comes into play

        //now it makes sense String name = person.isPresent()?person.get().getName():"Name not found"; is a
        //traditional way of handling the code and String name1 = person.map(Person::getName)//map will help us
        // to get name .orElse("No data found"); is a smarter way of handling the code
        System.out.println("OrElse Person Name : " + name1);
        System.out.println("===================================");
    }
    static void orElseGet(){
        Optional<Person> person = PersonRepository.getPersonOptional();//here we will get john as the object
        String name1 = person.map(Person::getName)
                .orElseGet( () ->{
                    //business logic to send a notification mail or Initiate any script
                //what we are trying to see here is if the data is available it will do the job and if not
                //available it will return no data found along with it will do some other operations also
                //because its a supplier method
                        return "data not found";
                });
//                .orElseGet(()-> "Data not found");//it accepts a supplier what supplier
        // do is it distribute some data but which will
        //you will wonder why its having an error here orElseGet(()-> return "Data not found") since i am
        // returning the data because its a single line
        //statement we dont need the return you can simply return data not found
        //not accept any input parameters so orelseget() we are not going to use any input parameters because
        //it is supplier syntax

        //incase if you have some business logic in the parameter of orelseGet() this is a supplier you can define
        //something here
        System.out.println("OrElseGet Person Name : " + name1);
        System.out.println("==================================");
    }
    static void orElseThrow(){
        Optional<Person> person = PersonRepository.getPersonOptional();
        String name1 = person.map(Person::getName)//after we made person name part as null only when control comes
                //here the name will be null here then it goes for the else block which will throw an exception
                .orElseThrow(() ->//it will accept a supplier as a parameter you dont have any input param for supplier
                    new RuntimeException("Name not found")
                );
        System.out.println("OrElseThrow Person Name : " + name1);
        //if the person :: getname is not available or the data is not available so we want to see when the
        //exception will occur if the name is not available the else part will work and the exception will be
        //thrown

        //to see how the else part will work we have to modify the person repository dont return whole as null
        //then orelse methods will not work only make the person part as null
        //ex- return new Person(null,165,2000,"Male",2, Arrays.asList("Cricket","Swimming","Tennis")); its correct
        //return null its not correct way of sending null values

        //output - Exception in thread "main" java.lang.RuntimeException: Name not found
    }
}
