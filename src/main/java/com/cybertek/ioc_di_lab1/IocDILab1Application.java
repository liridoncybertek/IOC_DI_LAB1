package com.cybertek.ioc_di_lab1;

import com.cybertek.ioc_di_lab1.instructor.Instructors;
import com.cybertek.ioc_di_lab1.student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IocDILab1Application {

    public static void main(String[] args) throws Exception {

        // Initialize bean.
        ApplicationContext bean = new AnnotationConfigApplicationContext(IocDILab1ApplicationConfig.class);
        // Declare instructor bean.
        Instructors instructors = bean.getBean(Instructors.class);
        // Declare student bean.
        Student students = bean.getBean(Student.class);

        System.out.println("Instructor title is: " + instructors.getMentorTitle(Title.API));
        System.out.println("Instructor title is: " + instructors.getMentorTitle(Title.JAVA));
        System.out.println("Instructor title is: " + instructors.getMentorTitle(Title.SELENIUM));

        // Dependency injection
        System.out.println("API working hours: " + instructors.getMentorsWorkingHours(Title.API));
        System.out.println("JAVA working hours: " + instructors.getMentorsWorkingHours(Title.JAVA));
        System.out.println("SELENIUM  working hours: " + instructors.getMentorsWorkingHours(Title.SELENIUM));

        // Dependency injection (override method from interface)
        System.out.println("Mentor title is: " + instructors.getMentorTitle(Title.API));
        System.out.println("Mentor title is: " + instructors.getMentorTitle(Title.JAVA));
        System.out.println("Mentor title is: " + instructors.getMentorTitle(Title.SELENIUM));

        System.out.println("Exact: " + students.calculateHours(Arrays.asList("Java Quizzes 1", "Selenium Topic 1", "Api Video 2")));
        System.out.println("Correct: " + students.calculateHours(Arrays.asList("Java Quizzes 2", "Selenium Topic 2", "Api Video 2")));
        System.out.println("Wrong: " + students.calculateHours(Arrays.asList("Java Quizzes 1", "Selenium Topic 1", "Api Video 10")));

        // Dependency injection
        System.out.println("API working hours: " + instructors.retrieveStudentWorkingHours(Title.API));
        System.out.println("JAVA working hours: " + instructors.retrieveStudentWorkingHours(Title.JAVA));
        System.out.println("SELENIUM  working hours: " + instructors.retrieveStudentWorkingHours(Title.SELENIUM));
    }

}
