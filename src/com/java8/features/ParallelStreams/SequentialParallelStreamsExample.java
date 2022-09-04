package com.java8.features.ParallelStreams;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelStreamsExample {
    public static void main(String[] args) {
        //we are trying to differentiate a sequential and the parallel how it is going to work
        //how the threads has been shared in parallel streams

        //creating array of strings
        String str[] = {"1","2","3","4","5","6","7","8","9","10"};
        //we will print this particular array in a sequential stream and also using parallel stream
        //we are going to pass the particular string to the particular print stream method but i need
        //to convert the data into a stream first so we are going to call the print stream
        System.out.println("---Sequential Run ----");
        printStream(Arrays.stream(str).sequential());
        //we all know how to convert an array to a stream by the above process
        //we are passing a stream but how to pass it sequentially so we can either do it by .sequential() or
        //or by default its a sequential right so anyway let me put it in a sequential way
        //output is a sequential list of streams from 1 - 10 which means it will run in a sequential manner
        //which is nothing but one by one i.e upto the first data has to be completed the second one has to wait
        //and upto second third will wait
        System.out.println("--- Parallel Run ---");
        //we will call the same method and which has the same data but we will use parallel stream
        printStream(Arrays.stream(str).parallel());
        //if we take look in the output which is 7,3,4,1,9 we will find that its not in the
        // proper order the reason is everything is working on a different thread here we can see two
        //unique thread names - ForkJoinPool and main that means i have two processor in my machine

        //there is a way we can identify how many processors are running in my machine
        System.out.println("No. of processors running: " + Runtime.getRuntime().availableProcessors());
        //it will give us the available processors in your machine just run it
        //the output is 4 this is the count of the process  that is the reason in my parallel run
        //we can see four different threads the first one is main(), second is ForkJoinPool.commonPool-worker-3
        //third one is ForkJoinPool.commonPool-worker-5 and fourth one is ForkJoinPool.commonPool-worker-7
    }
    static void printStream(Stream<String> stream){
        //
        stream.forEach(p ->{
            //printing local time
            //value here is my data element and we will show which thread is running
            //we will take the current thread
            System.out.println(LocalTime.now()+"Value :" + p +" - thread :" + Thread.currentThread().getName());
            //we are going to put the thread to sleep for 2secs
            //for that we need the try-catch block
            try{
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
