package com.java8.features.FunctionFunctionalInterface;

import java.util.Locale;
import java.util.function.Function;

public class FunctionInterfaceExample {
    static Function<String, String> f1 = name -> name.toLowerCase();
    public static void main(String[] args) {
        System.out.println("Result " + f1.apply("JAVA"));
    }
}
