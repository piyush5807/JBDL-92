package com.example.spring_profiling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FoodController {

    @Autowired
    FoodCustomProperties customProperties;

    @Value("${food}")
    private String food;

//    @Value("${staging.db.url}")
//    private String stagingDbUrl;
//
//    @Value("${prod.db.url}")
//    private String prodDbUrl;

    @Value("${food.cuisineName}")
    String cuisineName;

    @Value("${food.cuisineDescription}")
    String cuisineDescription;



    private static final Logger log = LoggerFactory.getLogger(FoodController.class);


    FoodController(
////                   @Value("${prop1}") String prop1,
//                   @Value("${prop2}") String prop2,
//                   @Value("${spring.application.name}") String appName
                   ) {
//        System.out.println("db url: " + dbUrl + " prop2: " + prop2 + " appName: " + appName);
        log.debug("Inside food controller constructor....");
    }

    @GetMapping("/food-details")
    public String getFoodDetails() {
        return "food-details : { " + customProperties.getCuisineDescription() + " " + customProperties.getCuisineName() + " }";
    }


}
