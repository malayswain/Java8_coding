package com.java8.features.Optional;

import com.java8.features.Repo.Address;
import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Optional;

public class OptionalMapExample {
    public static void main(String[] args) {
        //Like stream optional also has map method it is similar to stream map functionality and Optional map
        //will take Function Funtional Interface as a input
        //OptionalMapExample();
        //OptionalFlatMapExample();
        OptionalMapFilterExample();
        //In the stream we have flatmap() so in the similar way we have flatmap() in optional class.
        //The flatmap() in optional class takes funtion funtional interface as a input and return the data
        //
    }

    static void OptionalMapExample() {
        Optional<Person> person = PersonRepository.getPersonOptional();
        person.ifPresent(person1 -> {
            String name = person.map(Person::getName).orElse("No data found");
            //map under optional and map under stream is pretty much the same thing
            System.out.println(name);
        });
    }

    //here we are trying to retrieve the person address
    static void OptionalFlatMapExample(){

    Optional<Person> person = PersonRepository.getPersonOptionalAddress();
        if(person.isPresent())

    {
        //here we are trying to retrieve the data
        //here we are using flatmap() the reason is the person is a dto if youre returning any
        //information like name, height, salary etc.. you can use the map method but the data you are
        //trying to retrieve its already in another class or another kind of data so in order to flatten
        //the data you need to use the flatmap() here
        Optional<Address> address = person.flatMap(Person::getAddress);
        //getAddress will return optional of address
        //we will retrieve the data and store it in optional address type variable
        //using get() to get exact data
        System.out.println("Address :" + address.get());
        //output we got the address as a line object since we used the flatmap()
    }

}
        //Incase to filter out the data we can do that as in stream we use filter the optional have
        //a filter method which will help us to filter the data or sorting the data
        static void OptionalMapFilterExample(){
            Optional<Person> person = PersonRepository.getPersonOptionalAddress()//this part will return optional of person
                    .filter(person1 -> person1.getHeight()>=140);//here it will check whether the person has height of greater than 140
        //if it is greater than 140 then we will receive the data
        person.ifPresent(person2 -> System.out.println(person2.getAddress().get()));
            // we have the data in the above code we can filter from there as we got optional of person in above
        //line of code and we all know that filter will always take predicate as input which will return a bool
            //person.ifPresent(person1 -> );

            //why the output is coming as Optional[Address{block='7th Block', city='khandagiri', state=
            // 'Bhubaneswar', country='Odisha', pincode=751019}]
            //the reason is we just retrieved the person.getaddress() which will return optional<address>
            //to get exact address without optional use get();
        }
    }
