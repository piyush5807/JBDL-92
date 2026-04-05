package com.example.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class DemoController {

    @Autowired // this annotation is kept / used to tell SB to inject the object in this class that is already created by it.
    private DemoService dc;

//    @Autowired
//    private CustomBean customBean;

    @Autowired
    @Qualifier("getPerson")
    Person person;

//    @Autowired
//    @Qualifier("mapper_bean")
//    ObjectMapper objectMapper;

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${custom.prop}")
    private String customProperty;

    DemoController(){
        logger.info("DemoController being initialized....");
//        DemoService demoService = new DemoService();
    }

    @GetMapping("/demo")
    public String demo(){
//        ObjectMapper objectMapper = this.customBean.getMapper(); // with prototype scope, it's like creating a new object in every API call which is ideally not desirable
//        ObjectMapper mapper = new ObjectMapper();
        logger.info("person - {}", person);
        return "Hello World!!";
    }

    // DemoService being initialized... this - com.example.dependency_injection.DemoService@7aa9e414

    // demoService being used in demo controller... com.example.dependency_injection.DemoService@7aa9e414
}
