package com.java8.features.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class NumericIntStreamExample {
    //doing it using reduce() inside streams
    static BinaryOperator<Integer> binaryOperator = (x,y) -> x+y;
    static int calculateSum(List<Integer> l1){
        return l1.stream().reduce(0, binaryOperator);
        //reduce accepts initial value and binary operator
        //initial value is also called as seed value
        //we have list of integers which is nothing but wrapper class integers so when we tried to sum all those
        //elements we are opening a stream and we are reducing and we are passing a binary operator
        //here what will happen is all the wrapper class Integer they are converted into a primitive type int
        //then they will sum the data so the boxing is happening here tream().reduce(0, binaryOperator);
    }
    static int calculateSumWithStream(IntStream intStream){
        return intStream.sum();//there is a method sum() which will help us to do the sum operation here
        //but here intStream.sum() boxing is not happening because we are directly using the primitve intstream

    }
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);
        //we want to perform a operation at the end of the operation i want the sum of all the numbers in my list
        //we all know how to do that we can simply make use of the stream under reduce() method
        System.out.println(calculateSum(l1));
        //there is nothing wrong in this implementation but we can improve it
        //what basically happening is youre opening a stream and youre using a reduce function to do the
        //multiplication. we all know integer is a wrapper class of primitive int whenever you do any operation
        //under the integer so basically is happening is it will convert an integer a wrapper class integer to
        //int primitive type which is nothing but the unboxing event so that will take place and that will take
        //sometime but when youre directly went to intstream we can reduce that particular conversion part.

        //syntax of IntStream
        //it has two factory methods range() and rangeclosed()
        IntStream intStream = IntStream.rangeClosed(1,6);
        //The intstream rangeclosed method will accept two parameters it will create a data range between 1 - 6
        //means where to start(1) and where to end(6)
        //so we will pass the intstream to calculateSumWithStream()
        System.out.println("Total/Sum using Intstream " + calculateSumWithStream(intStream));

        //both return the same data but intstream is effective we are using direct primitive streams
        //so conversion the boxing and unboxing operation will not happen i.e unboxing wrapper Integer to
        //primitve int will not happen in IntStream
    }
}
