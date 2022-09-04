package com.java8.features.Stream;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.Optional;

public class StreamReducePersonExample {
    public static void main(String[] args) {
        combineNames();
        System.out.println("============================");
        Optional<Person> tallestPerson = getTallestPerson();
        System.out.println("Tallest Person is " + tallestPerson.get());
        //Optional[Person{name='Daddy'
        //if you want to get the data from optional or remove Optional[Person and have just the value
        //we simply use dot get() then we will get the plane data.
    }
    static void combineNames(){
        //we will concatenate all names like firstname with secondname and second name with third and so on
        String names = PersonRepository.getAllPersons().stream()//converting into stream
                .map(Person::getName)//extracting the name we have extracted all the names here
                .reduce("", (a,b) -> a.concat(b));//this particular function is going to ba apply for
        //each and every function and will perform the concatenation operation
        //in reduce first parameter is the starting value here in concatenation its
        //not required and second value is what is your functionality here means what your defining here
        //what this particular function has to do with all the elements. a,b are the two inputs
        //it will return a string
        System.out.println("concatenated names " + names);
    }
    static Optional<Person> getTallestPerson(){
        return  PersonRepository.getAllPersons()
                .stream()
                .reduce((x,y) -> x.getHeight() > y.getHeight() ? x : y);
        //here i dont have any starting and end value but here we dont have any start and end value
        //i have only the parameters the funtion parameters in this particular scenario we dont need the initial
        //value we are going to work with the elements which is there in my particular list
        //because we are not going to do any sum or multiplication operation or concate operation
        //we are just comparing the data
        //the first time x and y will receive values John and Malay from Personrepository it will
        //check which one is bigger x or y so x is bigger so it will return Malay then Malay becomes
        //the next initial value and then compare Malay with the Shree like that it continues
        //we wil use binary operator which has no starting value its a single function
        //there is no starting value so we will have two inputs
        //giving error cannot reduce optional person to person i.e its expecting a optional person
        //error fixing is replacing Person to Optional<Person>
        //so whenever you use reduce it will be always be written as an optional of data
    }
}
