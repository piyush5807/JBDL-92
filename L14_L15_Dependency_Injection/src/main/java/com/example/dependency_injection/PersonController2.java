package com.example.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController2 {

    private static Logger logger = LoggerFactory.getLogger(PersonController2.class);

//    @Autowired
    private PersonService personService;

    private String s = "Hello World!!!";

//    PersonController2(){
//        logger.info("Inside constructor, service - {}, s - {}", personService, s);
////        this.personService.random();
//    }

    PersonController2(PersonService personService){

        logger.info("PersonController2 constructor called, s - {}, local personService - {}, global personService - {}",
                s, personService, this.personService);
        this.personService = personService;
        this.personService.random();
    }

    /**
     * Fields + Non static blocks are initialized
     * Constructor is called
     *
     * ... any rest of the methods are invoked explicitly
     */

    @GetMapping("/person/v2")
    public String personV1(){

        logger.info("person service - {}", this.personService);
        return "Hello World!!!";
    }

    // v1 - person service - com.example.dependency_injection.PersonService@2a03d65c
    // v2 - person service - com.example.dependency_injection.PersonService@2a03d65c
}
