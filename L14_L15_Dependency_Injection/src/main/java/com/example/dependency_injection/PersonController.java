package com.example.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

//    @Autowired // field injection - mandatory here
//    private PersonService personService;


//    @Autowired
    private PersonService personService;


    // c1
    @Autowired
    public PersonController(PersonService personService, @Value("${custom.prop}") String s){
        this.personService = personService;
    }

    // c2
//    @Autowired
    public PersonController(@Value("${loan.duration}") Integer a){
        this.personService = new PersonService();
        System.out.println("a = " + a);
    }

    @GetMapping("/person/v1")
    public String personV1(){
        log.info("person service - {}", this.personService);
        return "Hello World!!!";
    }


    /**
     * 1. c1 will be used for creating an object of personController
     * 2. c2 will be used for creating an object of ^^
     * 3. we will get an error as there's a dilemma on which constructor to use
     * 4. default constructor will be used
     */
}
