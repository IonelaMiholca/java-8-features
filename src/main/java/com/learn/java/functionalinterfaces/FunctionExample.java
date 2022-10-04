package com.learn.java.functionalinterfaces;

import java.util.function.Function;

/**
 * This class shows how you can use the java.util.function.Consumer functional interface
 * introduced in java 8
 * <p>
 * The abstract method from this interface performs an operation on the given argument.
 * <p>
 * param t the input argument, it returns a value of type R
 * R apply(T);
 */

public class FunctionExample {
    public static void main(String[] args) {
        simpleFunctionExample();
        functionExampleWithAndThen();
        functionExampleWithCompose();
    }

    /**
     * Method that receives a String
     * Returns the String in upper cases
     */
    private static void simpleFunctionExample() {
        Function<String, String> function = (name) -> name.toUpperCase();
        String name = "peter";
        System.out.println("My name is " + function.apply(name) + ".");
    }


    private static void functionExampleWithAndThen() {
        Function<String, String> function = (name) -> name.toUpperCase();
        Function<String, String> addSomething = (name) -> name.concat(" example");
        System.out.println(function.andThen(addSomething).apply("java"));
    }

    /**
     * The compose method returns a composed function that first applies the before function to its input
     * and then applies this function to the result.
     */
    private static void functionExampleWithCompose() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;
        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        //first add 3 to the input and then multiply it by 2
        System.out.println(addThenMultiply.apply(3));
    }
}
