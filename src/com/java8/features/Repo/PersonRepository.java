package com.java8.features.Repo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
    public static List<Person> getAllPersons(){
        Person p1 = new Person("John",165,2000,"Male",2, Arrays.asList("Cricket","Swimming","Tennis"));
        Person p2 = new Person("Malay",166,2001,"FeMale",2, Arrays.asList("Driving","Dancing","Foodie"));
        Person p3 = new Person("Shree",100,20002,"Male",2, Arrays.asList("Binging","Gardening","Trekking"));
        Person p4 = new Person("Daddy",168,2003,"FeMale",2, Arrays.asList("Football","Gardening","Music"));
        Person p5 = new Person("Jeje",120,2004,"Male",2, Arrays.asList("Binging","Swimming","Cooking"));
        Person p6 = new Person("Hulu",164,2005,"FeMale",2, Arrays.asList("Painting","Cooking","Singing"));
        Person p7 = new Person("Goli",165,2005,"Male",2, Arrays.asList("Painting","Cooking","inging"));
        //return Arrays.asList(p1,p2,p3,p4,p5,null,p6,p7);
        return Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
    }
    public  static Person getPerson(){
        //return new Person(null,165,2000,"Male",2, Arrays.asList("Cricket","Swimming","Tennis"));
        return new Person("John",165,2000,"Male",2, Arrays.asList("Cricket","Swimming","Tennis"));
    }
    public static Optional<Person> getPersonOptional(){
        //we need to return as a optional so i am going to make use of Optional.of()
        //this method will return a Optional of data which we will provide it here
        //The data which we will provide we are going to call the getPerson() which eventually will return
        //a Person DTO so we are returning a person information here and i am sending them back as a optional
        //data so here optional person
        return Optional.of(getPerson());

        //used to send test null data.
        //return null;
    }
    public static Optional<Person> getPersonOptionalAddress(){
        Person per = getPerson();
        per.setAddress(Optional.of(new Address("7th Block","khandagiri","Bhubaneswar","Odisha",751019)));
        return Optional.of(per);
    }
}
