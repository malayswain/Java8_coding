package com.java8.features.Optional;

import java.util.Optional;

public class OptionalPresentMethodExample {
    public static void main(String[] args) {
        Optional<String> ofNullable = Optional.ofNullable("Java8");
        System.out.println(ofNullable.isPresent()?ofNullable.get():Optional.empty());
        //ispresent() will check whether the data is available or not

        //ifpresent()
        //if ispresent() is working properly then why do we need a ifpresent() method

        ofNullable.ifPresent(s -> System.out.println(s));
        //ifpresent() says if data available what i need to do i mean some operation we need to provide
        //so when we can have ifpresent() then we always have a else part it is like if condition to handle the
        //the else part we have some other methods also like orelse() and there are three types of orelse() with
        //different parameters like orElse() accepts data as param,orElseGet(takes supplier as param),
        // orElseThrow(takes supplier as param)

        //the ifpresent() accept a consumer and it consume nothing but you can apply some logic
        //or you can give some body in it you can tell the method what you need and what method has to do
        //we are going to print the data and we got the same output as ispresent()
        //ifpresent() is just to check when you are using if conditions
        //but when you are working with the data and youre checking whether ifpresent and if you want to perform
        //some operation you need to go for ifpresent() and then you can provide some consumer explanation or
        //body explanation
    }
}
