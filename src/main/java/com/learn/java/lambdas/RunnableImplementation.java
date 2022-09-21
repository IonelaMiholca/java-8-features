package com.learn.java.lambdas;

/**
 * This class is showing the implementation of the Functional Interface Runnable in two ways:
 * - before java 8
 * - with java 8 (using lambda functions)
 */
public class RunnableImplementation {

    public static void main(String[] args) {
        runnablePriorJava8();
        runnableWithJava8();
    }

    /**
     * prior java 8
     */
    private static void runnablePriorJava8() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable prior java 8");
            }
        };

        new Thread(runnable).start();
    }

    /**
     * using lambdas from java 8
     */
    private static void runnableWithJava8() {

        Runnable runnable1 = () -> {
            System.out.println("Inside Runnable with lambda 1");
        };
        new Thread(runnable1).start();

        //everything can be also written on a single line
        Runnable runnable2 = () -> System.out.println("Inside Runnable with lambda 2");
        new Thread(runnable1).start();

        //another way is without creating a new runnable object
        new Thread(() -> System.out.println("Inside Runnable with lambda 3")).start();

    }
}
