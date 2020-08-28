package com.cybertek.ioc_di_lab1.instructor;

import com.cybertek.ioc_di_lab1.Title;
import com.cybertek.ioc_di_lab1.mentor.Mentors;
import com.cybertek.ioc_di_lab1.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Instructors implements Instructor {

    private final String javaTitle;

    @Value("SeleniumInstructor")
    private String seleniumTitle;

    String apiTitle = "ApiInstructor";


    private final Mentors mentors;

    @Autowired
    private Student student;


    /**
     * Default constructor.
     */
    public Instructors(Mentors mentors) {
        this.javaTitle = "JavaInstructor";
        this.mentors = mentors;
    }

    /**
     * Get instructor title
     *
     * @param title instructorTitle {@link Title}
     * @return instructor title as string {@link String}
     */
    public String getInstructorTitle(Title title) {
        switch (title) {
            case API:
                return this.apiTitle;
            case SELENIUM:
                return this.seleniumTitle;
            case JAVA:
                return this.javaTitle;
            default:
                return "This title is not present in our area yet!";
        }
    }

    /**
     * Get working hours for mentors.
     *
     * @param title current title {@link Title}
     * @return working hours for mentor.
     */
    public String getMentorsWorkingHours(Title title) {
        return mentors.retrieveWorkingHours(title);
    }

    /**
     * Override method from interface for getting mentor title.
     *
     * @param title send title as paramter {@link Title}
     * @return Mentor title.
     */
    public String getMentorTitle(Title title) {
        return mentors.getInstructorTitle(title);
    }

    /**
     * Retrieve working hours for student
     * @param title title to attend
     * @return number of hours it attend
     * @throws Exception Exception.
     */
    public String retrieveStudentWorkingHours(Title title) throws Exception {
        return student.retrieveWorkingHours(mentors.getWorkingHours(title));
    }

}
