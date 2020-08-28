package com.cybertek.ioc_di_lab1.documentation;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class Documentation {
    private final Map<String, Integer> videosDummyData = new HashMap<String, Integer>();
    private final static Map<String, Integer> quizzesDummyData = new HashMap<String, Integer>();
    private final Map<String, Integer> topicsDummyData = new HashMap<String, Integer>();

    static {
       // WRITE YOUR CODE HERE..
    }

    public Documentation() {
        topicsDummyData.put("Java Topics 1", 20);
        topicsDummyData.put("Java Topics 2", 15);
        topicsDummyData.put("Selenium Topic 1", 15);
        topicsDummyData.put("Selenium Topic 2", 10);
        topicsDummyData.put("Api Topic 2", 10);
        topicsDummyData.put("Api Topic 1", 12);
    }

    @PostConstruct
    public void fillVideosDummyData() {
        videosDummyData.put("Java Video 1", 25);
        videosDummyData.put("Java Video 2", 15);
        videosDummyData.put("Selenium Video 1", 15);
        videosDummyData.put("Selenium Video 2", 10);
        videosDummyData.put("Api Video 1", 12);
        videosDummyData.put("Api Video 2", 8);
    }


    /**
     * Return all dummy data in one place.
     *
     * @return dummyData.
     */
    public Map<String, Integer> getDocumentationDummyData() {
        Map<String, Integer> dummyData = new HashMap<String, Integer>();
        //WRITE YOUR CODE HERE...
        return dummyData;
    }

}
