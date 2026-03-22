package com.example.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // MVC - Model View Controller

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String greeting() throws InterruptedException {
        LOGGER.info("Request received...");
//        while(true){
//            Thread.sleep(4000);
//            break;
//        }
        return "Hello World!";
    }
}
