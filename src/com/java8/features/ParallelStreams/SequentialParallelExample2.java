package com.java8.features.ParallelStreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SequentialParallelExample2 {
    //To show how difference between sequential and parallel time difference
    //We will create two methods which will give us the sum of 0 to 100
    static int sumMethodUsingSeq(){
        //we are going to return a sum of zero to 100 or 1000 so that why need to have
        // Numeric stream in this case a IntStream
        return IntStream.rangeClosed(0,10000000).sum();
    }
    //We are going to create another method which will do the same but that is going to work as a parallel
    //manner
    static int sumMethodUsingParallel(){
        return IntStream.rangeClosed(0,10000000).parallel().sum();
    }
    //when you work in multiple number of threads so how it is going to be identify which method or which
    //stream is going to be faster
    //let us create an interface method to run the same method multiple times and we will see which method
    //is performing faster
    static long checkPerformance(Supplier<Integer> sum, int numOfTimes){
        //this method will accept supplier as a parameter which will return a integer
        //numOfTimes is to denote how many times we are going to execute the method
        //another thing is that we need to calculate the timing the start and the end time
        //so we need to have another variable here to store the start time so using currentTimeMillis() for it
        //which will help us to identify when the process has been started and we are going to create another
        //parameter to identify the end time also
        long start = System.currentTimeMillis();
        //in between we are going to create a for loop
        for(int i = 0; i<=numOfTimes; i++){
            //we are going to call the method so i have a supplier so supplier method is nothing but get()
            //which will run the method and sum is the reference of supplier
            //here the sum.get() method which will run the method <numofTimes> number of times
            sum.get();
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
    public static void main(String[] args) {
        System.out.println("Sum from seq manner " + sumMethodUsingSeq());
        System.out.println("Sum from parallel manner " + sumMethodUsingParallel());
        System.out.println("===================================");
        //here we will call the checkPerformance method which will accept a supplier
        //how can we pass the supplier -> because in supplier some methods use segement or sequential flow
        //and parallel flow so we can use the method reference other than it like classname.methodname wont work
        //even though its having static method
        //here first parameter is SequentialParallelExample2::sumMethodUsingSeq for whom we will test the performance
        //so we have used method reference to call it
        //numOfTimes = 25 means no. of times we want to execute this sumMethodUsingSeq method
        //we are going to do the same above things for parallel.
        System.out.println("Sum from seq :" + checkPerformance(SequentialParallelExample2::sumMethodUsingSeq,25));
        System.out.println("Sum from parallel :" + checkPerformance(SequentialParallelExample2::sumMethodUsingParallel,25));

        //output - we concluded that if we take small value in IntStream.rangeClosed(0,1000) then sequential works
        //better than parallel in adding/suming in which sequential took 1ms and parallel took 4ms
        // but when the value drastically increases/huge amount of data like IntStream.rangeClosed(0,1000000000)
        //then parallel works better than sequential in adding/suming in which sequential
        // took 76ms and parallel took 35ms

        //In this kind of straightforward logic whether you dont have to do any internal modification like
        //if you are executing 100s of records that is okay but while executing it you are making some operations
        //or you are performing some object modifications those kind of scenarios if you go for parallel then we will
        //end up with an issue but for straightforward kind of iteration it always good to go with the parallel
        //but it always advisable before you decide which stream youre going to use just run it mutiple times and
        //see which one is giving the better performance
    }
}
