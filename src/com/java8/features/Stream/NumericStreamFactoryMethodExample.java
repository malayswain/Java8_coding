package com.java8.features.Stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamFactoryMethodExample {
    public static void main(String[] args) {
        //Performing an operation like kind of we want to sum the value from 1 to 50 these are very difficult
        //in the traditional model but from java8 it is pretty easier for us we can make use of the aggregation
        //method like sum, max or min.

        //we can use sum() to sum up the values amd it will return an int data
        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("total is " + sum);

        //like sum() we have max(), min() and avg()
        //sum() will return int as the outcome  but min() and max() will return OptionalInt or OptionalLong
        //average() method returns Optional value
        OptionalInt max = IntStream.rangeClosed(1,50).max();
        System.out.println("max value is " + max.getAsInt());
        //when we use optional if you want to get the exact data from the optional we need to use the get()
        //since we are using optionalInt we need to use getasint() or getaslong() depending
        //similarly we can try for min() and average() which will return a Optional value
    }
}
