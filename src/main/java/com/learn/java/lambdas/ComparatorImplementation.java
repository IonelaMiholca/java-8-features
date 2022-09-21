package com.learn.java.lambdas;

import java.util.Comparator;

/**
 * This class is showing the implementation of the Functional Interface Comparator in two ways:
 * - before java 8
 * - with java 8 (using lambda functions)
 */
public class ComparatorImplementation {
    private static final Integer number1 = 1;
    private static final Integer number2 = 2;

    public static void main(String[] args) {
        comparatorPriorJava8();
        comparatorWithLambda();
    }

    /**
     * prior java 8
     */
    public static void comparatorPriorJava8() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /*
                * -1 -> o1<o2
                * 0 -> o1==o2
                * 1 -> o1>o2
                */
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of the comparison prior java 8 is: " + comparator.compare(number1, number2));
    }

    /**
     * using lambda java 8
     */
    public static void comparatorWithLambda() {
        Comparator<Integer> comparator1 = (Integer o1, Integer o2) -> {
            return o1.compareTo(o2);
        };

        System.out.println("Result of comparison 1 with lambda is " + comparator1.compare(number1, number2));

        //everything can be also written on a single line
        Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> o1.compareTo(o2);
        System.out.println("Result of comparison 2 with lambda is " + comparator1.compare(number1, number2));

        //because the type of the comparator is Integer it is not needed to specify the type of parameters
        Comparator<Integer> comparator3 = (o1, o2) -> o1.compareTo(o2);
        System.out.println("Result of comparison 3 with lambda is " + comparator1.compare(number1, number2));
    }
    
}
