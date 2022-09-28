package com.learn.java.functionalinterfaces;

import java.util.function.Predicate;

/**
 * This class shows how you can use the java.util.function.Predicate functional interface
 * introduced in java 8
 * <p>
 * The abstract method from this interface performs an operation on the given argument.
 * <p>
 * param t the input argument
 * boolean test(T t);
 */
public class PredicateExample {

    public static void main(String[] args) {
        isNumberEvenWithLambda();
        predicateAnd();
        predicateOr();
        predicatNegate();
    }

    //method that prints if a number is even
    private static void isNumberEvenWithLambda() {
        Predicate<Integer> p1 = (n) -> {
            return n % 2 == 0;
        };
        System.out.println("Is 4 an even number: " + p1.test(4));

        //short version
        Predicate<Integer> p2 = (n) -> n % 2 == 0;
        System.out.println("Is 3 an even number: " + p2.test(3));
    }

    //method that prints if a number is divisible by 2 and 5 using Predicate.and();
    private static void predicateAnd() {
        Predicate<Integer> p1 = (n) -> n%2==0;
        Predicate<Integer> p2 = (n) -> n%5==0;

        //predicate chaining
        System.out.println("Is 10 divisible by 2 and 5: " +p1.and(p2).test(10));
        System.out.println("Is 8 divisible by 2 and 5: " + p1.and(p2).test(8));
    }

    //method that prints if a number is divisible by 2 or 5 using Predicate.or();
    private static void predicateOr() {
        Predicate<Integer> p1 = (n) -> n%2==0;
        Predicate<Integer> p2 = (n) -> n%5==0;

        //predicate chaining
        System.out.println("Is 4 divisible by 2 or 5: " + p1.or(p2).test(4));
        System.out.println("Is 15 divisible by 2 or 5: " +p1.or(p2).test(15));
        System.out.println("Is 9 divisible by 2 or 5: " +p1.or(p2).test(9));
    }

    //method that prints the negation of a number is divisible by 2 or 5 using Predicate.negate();
    private static void predicatNegate() {
        Predicate<Integer> p1 = (n) -> n%2==0;
        Predicate<Integer> p2 = (n) -> n%5==0;

        //predicate chaining
        System.out.println("Negate method - Is 4 divisible by 2 or 5: " + p1.or(p2).negate().test(4));
        System.out.println("Negate method - Is 15 divisible by 2 or 5: " +p1.or(p2).negate().test(15));
        System.out.println("Negate method - Is 9 divisible by 2 or 5: " +p1.or(p2).negate().test(9));
    }

}
