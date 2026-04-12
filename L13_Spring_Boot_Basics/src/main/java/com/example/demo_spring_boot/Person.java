package com.example.demo_spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {

    private static Logger logger = LoggerFactory.getLogger(Person.class);

    Person(){
        logger.info("Person object created");
    }

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer id, String name) {
        logger.info("Person object created");
        this.id = id;
        this.name = name;
    }
}
