package com.cybertek.ioc_di_lab1.mentor;

import com.cybertek.ioc_di_lab1.Title;
import com.cybertek.ioc_di_lab1.instructor.Instructor;
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

    public String getMentorTitle(Title title) {
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

    /**
     * Get working hours as integer.
     * @param title param title
     * @return working
     */
    public Integer getWorkingHours(Title title) {
        switch (title) {
            case JAVA:
                return 25;
            case API:
                return 5;
            case SELENIUM:
                return 40;
            default:
                return 0;
        }
    }
}
