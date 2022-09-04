package com.java8.features.ParallelStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWhenNotToUse {
    public static void main(String[] args) {
        //basically the one thing we should keep in mind when there is a iteration process which will not do any
        //intermediate operation like modifying the parameter inside a loop or a for-each those kind of situations
        //we are good to go with the parallel stream.

        //but the thing is we have hundereds of elements and it has stored in a list we are iterating it but
        //everytime we are iterating we are modifying one particular data into a particular object so in that
        //case if we are going for parallel stream it leads to an issue so we will see it.

        //Usecase - We are going to calculate the sum of the range of data.
        //we need to call the method and pass list of integers
        //we can use Intstream which will help us to create a range of data
        List<Integer> list = IntStream.rangeClosed(1,10000).boxed()
                .collect(Collectors.toList());//we just boxed the data and then we are passing the list
        //so here we will not have any impact on performance

        //if we do this List<Integer> list = IntStream.rangeClosed(1,10000)
        // .collect(Collectors.toList()); it will throw a error collect(java.util.function.Supplier<R>,
        // java.util.function.ObjIntConsumer<R>,
        // java.util.function.BiConsumer<R,R>)' in 'java.util.stream.IntStream' cannot
        // be applied to '(java.util.stream.Collector<java.lang.Object,capture<?>,java.util.List<java.lang.Object>>
        //IntStream.rangeClosed(1,10000).collect(Collectors.toList()); will return primitive int
        // So what Intstream will do it will return a primitive integer data but here we are expecting as a
        //wrapper class Integer in List<Integer> so to resolve this error before collecting the data we need to
        //box it box will covert the type from primitive type to a wrapper class type

        sequentialCalculation(list);
        parallelCalculation(list);

        //output - we can see the difference now the sequential duration is 2ms but parallel is 5ms
        //why parallel is slow here? - The reason is we all know that if it is a straightforward iteration
        //parallel will work as fast as possible compared to sequential but here what we are trying to do is
        //we are trying to convert your data

    }
    static int sequentialCalculation(List<Integer> list){
        long start = System.currentTimeMillis();
        // we have list of integers as input
        int total = list.stream()//we are going to iterate the list and convert into stream
                .reduce(0, (x,y) -> x+y);
        //here also the total will be keep on updated but faster than parallel

        //it will accept two parameters one is starting point and second is the parameters
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration : " + (end-start));
        return total;
    }
    static int parallelCalculation(List<Integer> list){
        long start = System.currentTimeMillis();
        // we have list of integers as input
        int total = list.parallelStream()//we are going to iterate the list and convert into stream
                .reduce(0, (x,y) -> x+y);
        //This is the place where the performance issue is happening can you take a look the reduce() is
        //working with the variables so each and every time the total will be keep on updated

        //The parallel execution there are multiple threads processing the data and each of them returning
        //a response and then again they club together and then again working then again they are trying to do
        //the same operation so whenever any places if you try to modify an object you cannot go for parallel
        //stream so in those kind of scenarios sequential stream is far better and more effective also

        //it will accept two parameters one is starting point and second is the parameters
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration : " + (end-start));
        return total;
    }
}
