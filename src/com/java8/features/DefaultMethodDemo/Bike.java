package com.java8.features.DefaultMethodDemo;

public class Bike implements Vehicles{

    @Override
    public void horn() {
        System.out.println("Bike makes bam bam sound");
    }

    @Override
    public void speedMeter() {
        System.out.println("speedometer limit is only 180km/h");
    }
}
