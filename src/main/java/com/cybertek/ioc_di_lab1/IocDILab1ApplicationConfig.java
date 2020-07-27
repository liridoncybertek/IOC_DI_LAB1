package com.cybertek.ioc_di_lab1;

import com.cybertek.ioc_di_lab1.documentation.Documentation;
import com.cybertek.ioc_di_lab1.instructor.Instructors;
import com.cybertek.ioc_di_lab1.mentor.Mentors;
import com.cybertek.ioc_di_lab1.student.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class IocDILab1ApplicationConfig {

    @Bean
    public Instructors instructors() {
        return new Instructors(mentors());
    }

    @Bean
    public Mentors mentors() {
        return new Mentors();
    }

    @Bean
    public Documentation documentation() {
        return new Documentation();
    }

    @Bean
    public Student student() {
        return new Student();
    }
}
