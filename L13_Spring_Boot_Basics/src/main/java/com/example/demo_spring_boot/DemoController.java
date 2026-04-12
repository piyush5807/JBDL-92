package com.example.demo_spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@ResponseBody
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    DemoController(){
        logger.info("DemoController object being initialised");
    }

    @GetMapping("/demo")
    public Person demo(){
        return new Person(1, "Piyush");
    }

//    @GetMapping("/demo")
//    public String getDemo(){
//        return "Demo happening!!";
//    }


    @PostMapping("/demo")
    public String demo2(@RequestBody Person person){
        return "Demo Happening from Post!!";
    }

    @PutMapping("/demo")
    @PatchMapping("/demo")
    public String demo3(){
        return "Demo Happening from Put / Patch!!";
    }

    // This url to function mapping happens only for those classes functions which are annotated with controller either directly or indirectly
    // 1. { key = ({GET "/demo"}) , value = com.example.demo_spring_boot.DemoController#demo() }
    // 2. { key = ({POST "/demo"}), value = com.example.demo_spring_boot.DemoController#demo2() }
    // 3. { key = (PATCH "/demo"),  value = com.example.demo_spring_boot.DemoController#demo3() }
    // 4. { key = (PUT "/demo"),    value = com.example.demo_spring_boot.DemoController#demo3() }
    // 5. { key = ({GET "/demo"}),  value = com.example.demo_spring_boot.DemoController#getDemo() }

    /**
     * A. application will run, but we will get an error on calling GET /demo from client side
     * B. application will run, no error and getDemo will run upon calling GET /demo from client side
     * C. application will not run and there will be error before application start up
     */


}
