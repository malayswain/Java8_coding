package com.java8.features.Stream;

import java.util.stream.IntStream;

public class NumericIntStreamFactory {
    public static void main(String[] args) {
        //so lets create a range of data
        IntStream intStream = IntStream.rangeClosed(1,6);
        //rangeclosed() accept two parameters and its second parameter is endInclusive means start and end
        // element will be both there in the o/p and range() also accepts
        //two parameter its second parameter is endExclusive means doesnt print the last value
        //but end element will not print in range()
        IntStream intStream1 = IntStream.range(1,6);
        intStream.forEach(System.out::println);
        System.out.println("==============================");
        intStream1.forEach(System.out::println);
        //same applies for Longstream and DoubleStream

    }
}
