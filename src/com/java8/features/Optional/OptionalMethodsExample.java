package com.java8.features.Optional;

import java.util.Optional;

public class OptionalMethodsExample {
    public static void main(String[] args) {
        //We are going to discuss the methods available inside optional class
        //we are going to cover optional.of,optional.empty,optional.nullable

        //Optional.ofnullable
        //we are going to create an optional string here

        //what will happen if we pass null
        Optional<String> ofNullable = Optional.ofNullable("Java8");
        //we will get an java.util.NoSuchElementException: No value present exception
        //so whenever you are using off nullable make sure you are checking whether ispresent() is available
        //then print the data or else empty so how we can modify
        //use <optional var>.ispresent() : <optional var>.get() to get data :<any error message> or Optional.empty
        //now we will not end up with a null pointer exception issue or any runtime exception issue
        System.out.println(ofNullable.isPresent()?ofNullable.get():Optional.empty());

        //Optiona.of()
        //Optional<String> ofNullable = Optional.ofNullable("Java8");
        //if data is available it will return the optional of data in this case optional of string data
        //or else optional of empty and if we want to get the exact data or raw data use the get()

        //Optional<String> ofN = Optional.of("Java8");
        //output - optional.of is returning a not null value always whatever data youre processing inside
        //and moreover the optional.of() which will always used whenever we are sure that there will be no
        //null value inside then we can go for optional.of()

        //--> this cannot happen Optional<String> of = Optional.of(null);
        // if used null it will fail from here itself cannot reach
        //ispresent() means it wont go to the next line

        Optional<String> of = Optional.of("Hello World");
        //when we do need of() when your make or when your sure that there will be no null its going to come
        //in a particular area or like hardcoded data it cannot be null and it never be null. so if you want to
        //return some data as the optional data use of()
        //if its may be null or may not be null then in that case you can go for ofnullable()
        //The optional.of() is created to make any data as an optional data.
        System.out.println(of.isPresent()?of.get():Optional.empty());
        //if we pass null value in Optional.of() parameter then we will get java.lang.NullPointerException
        //it cannot be handled by ispresent() also so optional.of() parameter can never be null

        //Optional.empty()
        //it will return a empty optional lets print one optional.empty()
        System.out.println(Optional.empty());
        //so optional.empty() is always a else block material whenever something is there you are sending the
        //data or else we are going to send an empty data
    }
}
