package com.java8.features.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {
    public static void main(String[] args) {
        //reduce means working with the data and come up with a summarized solution
        //for example i have 10 numbers in my list sum of every numbers will return a data
        //ex- if a num is 1+2+5+1+3+4 is some data and doing the procees and returning a single data
        //system.reduce is a general purpose method for generating your custom generation operation
        //the operation which you are going to provide inside the reduce its user defined
        //we can check whatever conditions we want
        //basically the method performs here reduction, reduction on elements of the stream,
        //in stream we have number of elements the functionality which we are going to provide
        //will apply to each and every elements and give us an accumulation data
        List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5);
        int sum = listOfIntegers.stream()
                .mapToInt(i -> i).sum();
        System.out.println("Sum Result " + sum);
    }
}
