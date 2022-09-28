package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class shows how you can use the java.util.function.BiPredicate functional interface
 * introduced in java 8
 * <p>
 * The abstract method from this interface performs an operation on the given argument.
 * <p>
 * params t and u the input arguments
 * boolean test(T t, U u);
 */
public class BiPredicateExample {
    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    public static void main(String[] args) {
        exampleWithSimplePredicate();
        exampleWithBiPredicate();
    }


    /**
     * method that prints the names of the students with gradeLevel>=3 and gpa >= 3.9
     * using two simple predicates
     */
    private static void exampleWithSimplePredicate() {
        Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
        Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;
        Consumer<Student> studentConsumer1 = ((student) -> {
            if(p1.and(p2).test(student)){
                System.out.println(student.getName());
            }
        });

        StudentDataBase.getAllStudents().forEach(studentConsumer1);
    }
    /**
     * method that prints the names of the students with gradeLevel>=3 and gpa >= 3.9
     * using BiPredicate
     */
    private static void exampleWithBiPredicate() {
        BiPredicate<Integer, Double> p1 = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
        Consumer<Student> studentConsumer1 = ((student) -> {
            if(p1.test(student.getGradeLevel(), student.getGpa())){
                System.out.println(student.getName());
            }
        });

        StudentDataBase.getAllStudents().forEach(studentConsumer1);
    }

}