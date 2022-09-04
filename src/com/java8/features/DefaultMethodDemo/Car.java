package com.java8.features.DefaultMethodDemo;

public class Car implements Vehicles{

    @Override
    public void horn() {
        System.out.println("Car makes honk honk sound");
    }
}
