package com.cybertek.ioc_di_lab1.instructor;

import com.cybertek.ioc_di_lab1.mentor.Mentors;
import java_bean_configuration_lab_1.Title;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Instructors implements Instructor {

    private final String javaTitle;

    @Value("SeleniumInstructor")
    private String seleniumTitle;

    String apiTitle = "ApiInstructor";


    private final Mentors mentors;


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

}
