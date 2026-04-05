package com.example.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class DemoController2 {

    @Autowired // this annotation is kept / used to tell SB to inject the object in this class that is already created by it.
    private DemoService dc;

//    @Autowired
//    private CustomBean customBean;

    @Autowired
    Person person;

    private static Logger logger = LoggerFactory.getLogger(DemoController2.class);

    // GET localhost:8080/demo2
    // POST localhost:8080/demo2
    // ES - Elastic Search  GET / POST search(query)

//    @GetMapping("/demo2")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/demo2")
    public String demo(){
//        ObjectMapper objectMapper = this.customBean.getMapper();
        logger.info("person - {}", person);
        return "Hello World2!!";
    }

    // DemoService being initialized... this - com.example.dependency_injection.DemoService@7aa9e414

    // demoService being used in demo controller... com.example.dependency_injection.DemoService@7aa9e414
}
