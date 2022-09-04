package com.java8.features.ParallelStreams;

import java.util.stream.IntStream;

public class ParallelWhenNotToUseExample {
    public static void main(String[] args) {
        Calculation cal = new Calculation();
        IntStream.rangeClosed(0,2000).// by default its a stream we have created a stream of data which is o to 2000
                forEach(cal::calculate);//here i am iterating the data so everytime we are passing the data from here
        //to this foreach method and its like a for loop so data will keep on passed the method which i am calling
        //the calculate what the calculator will do it by default adding the total or keep updating the total
        //with the current number this is object reference model like we used to do classname :: method name
        //same way we can use the object and the method name also

        //everytime we will pass the data to foreach to call the method inside the
        System.out.println("Result in seq : " + cal.getTotal());
        IntStream.rangeClosed(0,2000).parallel().forEach(cal::calculate);
        //here cal is the object and calculate is a method so its called object reference not method reference
        System.out.println("Result in parallel : " + cal.getTotal());

        //output - Result in seq : 2001000 and Result in parallel : 4002000 now you know the differnce why we keep
        //telling that when your data keep updating we cannot go for the parallel streams.
        //the sequential is returning proper data by adding the parallel returning some wrong data
        //everytime we will get different output from the parallel execution the reason is the variable is
        //updated by different different threads so the one thread will not be aware of previous thread what it
        //is doing so everything is working independently of each other so those kind of scenarios when you go
        //for the parallel it not only leads to a performance issue but also leads to a invalid data or wrong data
        //so whenever your using parallel stream make sure is it really necessary because whereever your trying
        //to update the code or your trying to code you can simple go and work with the streams which means
        //sequential streams its not going to impact anything but when your going for parallel you need to
        //consider few parameters 1st is, is it really necessary the second thing is will it improve my
        //performance and 3rd is even if it improves my performance will it give the proper or valid outcome those things we
        //need to keep in your mind always
    }
}
class Calculation{
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void calculate(int in){
        total += in;
    }
}
