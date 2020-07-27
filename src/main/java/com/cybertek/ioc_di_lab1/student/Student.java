package com.cybertek.ioc_di_lab1.student;

import com.cybertek.ioc_di_lab1.documentation.Documentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Student {
    private final static int maxHours = 30;

    /**
     * Autowired documentation component
     */
    @Autowired
    public Documentation documentation;

    /**
     * get documentation dommy data for quizzes videos and topics.
     *
     * @return data in specific format {@link Map<String, Integer>}
     */
    public Map<String, Integer> getDocumentation() {
        return documentation.getDocumentationDummyData();
    }

    /**
     * Calculate hours for documentation that user choose
     *
     * @param documentations list of documentations that user choose
     * @return calculcated hours with specific message.
     * @throws Exception Exception.
     */
    public String calculateHours(List<String> documentations) throws Exception {
        /**
         * Java stream an example how to use it.
         * Return sum of hours following the list of documentations.
         */
        Integer hours = getDocumentation()
                .entrySet()
                .stream()
                .filter(gd -> documentations.stream()
                        .anyMatch(doc -> doc.equalsIgnoreCase(gd.getKey())))
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum);

        if (hours > maxHours) {
            throw new Exception("You can't follow more than 30 hours in a week");
        }

        if (hours < maxHours) {
            return "This week you have a plan to attend " + hours + " hours of teaching. You have " + (maxHours - hours) + " hours left unused";
        }

        return "This week you have a plan to attend " + hours + " hours of teaching.";
    }
}
