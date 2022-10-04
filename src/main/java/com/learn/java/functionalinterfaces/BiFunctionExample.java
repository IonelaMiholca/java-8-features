package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * This class shows how you can use the java.util.function.BiFunction functional interface
 * introduced in java 8
 * <p>
 * The abstract method from this interface performs an operation on the given argument.
 * <p>
 * params t and u the input arguments, it returns a value of type R
 * R apply(T t, U u);
 */
public class BiFunctionExample {

    public static void main(String[] args) {
        biFunctionExample();
    }

    /**
     * Method that prints all the student name + the student's gpa for students that have gradeLevel >= 3
     */
    private static void biFunctionExample() {
        Predicate<Student> gradePredicate = (s) -> s.getGradeLevel() >= 3;
        BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) -> {

            Map<String, Double> studentGradeMap = new HashMap<>();
            students.forEach((student -> {
                if (studentPredicate.test(student)) {
                    studentGradeMap.put(student.getName(), student.getGpa());
                }
            }));
            return studentGradeMap;
        };
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), gradePredicate));
    }
}
