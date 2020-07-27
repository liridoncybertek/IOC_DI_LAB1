package com.cybertek.ioc_di_lab1.mentor;

import com.cybertek.ioc_di_lab1.instructor.Instructor;
import java_bean_configuration_lab_1.Title;
import org.springframework.stereotype.Component;

@Component
public class Mentors implements Instructor {

    /**
     * Retrieve working hours for week for specific mentor.
     *
     * @param title title {@link Title}
     * @return working hours for week
     */
    public String retrieveWorkingHours(Title title) {
        switch (title) {
            case JAVA:
                return "Working 25 hours for week!";
            case API:
                return "Working 5 hours for week!";
            case SELENIUM:
                return "Working 10 hours for week!";
            default:
                return "I don't work in this part this week!";
        }
    }

    public String getInstructorTitle(Title title) {
        switch (title) {
            case API:
                return "Api Mentor";
            case SELENIUM:
                return "Selenium Mentor";
            case JAVA:
                return "Java Mentor";
            default:
                return "This mentor is not present in our area yet!";
        }
    }
}
