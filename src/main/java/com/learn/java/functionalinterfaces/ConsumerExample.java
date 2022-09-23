package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

/**
 * This class shows how you can use the java.util.function.Consumer functional interface
 * introduced in java 8
 *
 * The abstract method from this interface performs an operation on the given argument.
 *
 * param t the input argument
 * void accept(T t);
 */
public class ConsumerExample {
    public static void main(String[] args) {
        consumerExampleWithLambda();
        consumerRealWorldExamples();
    }

    /**
     * simple consumer example using lambda
     * this method print the string "TEST"
     */
    public static void consumerExampleWithLambda() {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("test");
    }

    private static void consumerRealWorldExamples() {
        printStudents();
        printNamesAndActivities();
        printNamesAndActivitiesWithCondition();
    }

    private static void printStudents() {
        Consumer<Student> c2 = (s) -> System.out.println(s);
        StudentDataBase.getAllStudents().forEach(c2);
    }

    /**
     * example using consumer chaining with .andThen() method from Consumer interface
     */
    private static void printNamesAndActivities() {
        System.out.println();
        Consumer<Student> c3 = (s) -> System.out.print(s.getName());
        Consumer<Student> c4 = (s) -> System.out.println(s.getActivities());
        StudentDataBase.getAllStudents().forEach(c3.andThen(c4));
    }

    /**
     * Another example of consumer chaining also with a conditional lambda inside forEach
     */
    private static void printNamesAndActivitiesWithCondition() {
        System.out.println();
        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> c5 = (s) -> System.out.print(s.getName());
        Consumer<Student> c6 = (s) -> System.out.println(s.getActivities());

        studentList.forEach((s) -> {
            if(s.getGradeLevel() >= 3) {
                c5.andThen(c6).accept(s);
            }
        });
    }

}
