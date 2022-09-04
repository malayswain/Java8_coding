package com.java8.features.ParallelStreams;

import com.java8.features.Repo.Person;
import com.java8.features.Repo.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamPersonUseCaseExample {
    public static void main(String[] args) {
        //we are trying to retrieve the hobbies of each and every person means all persons hobbies
        System.out.println(getHobbiesBySeq());
        System.out.println(getHobbiesByPara());

        //output = Parallel is very much faster but why there is time difference
        //The reason is we are trying to flatten the map that means there are some conversions happening
        //here so when the conversions are happening it normally will take little bit more time because
        //its not only mapping the data its flattening the data and again mapping it so that conversion part
        //is happening but when the parallel process is doing the same thing what will happen is since we are
        //using the parallel stream there are multiple threads sharing the job and they are all together
        //doing the same job and give the result but then the sequential way its a single thread handling
        //the entire operation so it has to be then one by one so one has to wait for the previous one the
        //next one has to wait for the previous one so it happened till start to the end so thats why
        //we have this much time difference from this we might understand when to use parallel and

        // when not to use parallel so whenever the data flow is happening directly we can go for parallel stream
        //and even its okay to go with the stream also but what we are trying to understand is when to use parallel

    }
    //this method will be sequential
    static List<String> getHobbiesBySeq(){
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersons()
                .stream()//this is same as sequential stream and by default it is sequential
                .map(Person::getHobbies)//because we need to retrieve the hobbies inside the person class
                .flatMap(List ::stream)//here it will return list of strings
                //in this part of conversions or flattening the time difference between parallel and seq happen
                .collect(Collectors.toList());
        //there is a problem here it is not going to return as list because person and it has list of hobbies
        //we need to flatten the map so that it should return list of strings

        //we need to find out which method is running faster
        //so we will define a variable start time
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration : " + (end-start));
        return hobbies;
    }
    //this method will be parallel
    static List<String> getHobbiesByPara(){
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersons()
                .parallelStream()//here we will be using a parallel stream
                .map(Person::getHobbies)
                .flatMap(List ::stream)
                //here we are flattening the data and mapping it
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration : " + (end-start));
        return hobbies;
    }
}
