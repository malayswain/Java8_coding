package com.java8.features.DefaultMethodDemo;

public interface Vehicles {
    public void horn();
    default void speedMeter(){
        System.out.println("speed is a common function");
    }
    static void light(){
        System.out.println("All vechiles have lights");
    }
}
