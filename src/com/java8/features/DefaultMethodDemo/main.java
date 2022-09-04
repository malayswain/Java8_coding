package com.java8.features.DefaultMethodDemo;

public class main {
    public static void main(String[] args) {
        Vehicles vehicles = new Car();
        Vehicles vehicles1 =  new Bike();
        vehicles.horn();
        vehicles1.horn();
        vehicles.speedMeter();
        vehicles1.speedMeter();
        Vehicles.light();
    }
}
