package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * This class shows how you can use the java.util.function.BiConsumer functional interface
 * introduced in java 8
 *
 * The abstract method from this interface performs an operation on the given arguments.
 *
 * params t and u the input arguments
 * void accept(T t,U u);
 */
public class BiConsumerExample {
    public static void main(String[] args) {
        biConsumerExampleWithLambda();
        biConsumerPrintNameAndActivities();
    }

    /**
     * simple BiConsumer example using lambda
     * this method print the string "Hello World"
     */
    private static void biConsumerExampleWithLambda() {
        BiConsumer<String, String> s = (a, b) -> System.out.println(a + " " + b);
        s.accept("Hello", "World");

        BiConsumer<Integer, Integer> multiplication = (n1, n2) -> {
            System.out.println("Multiplication: " + (n1*n2));
        };
        BiConsumer<Integer, Integer> division = (n1, n2) -> {
            System.out.println("Division: " + (n1/n2));
        };

        multiplication.andThen(division).accept(20, 4);
    }

    /**
     * Real world example of using BiConsumer to print names and activities of the students
     */
    private static void biConsumerPrintNameAndActivities() {
        List<Student> studentList = StudentDataBase.getAllStudents();

        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " :" + activities);
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }
}
