package com.example.spring_profiling;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("food")
@Configuration
public class FoodCustomProperties {

    private String cuisineName;
    private String cuisineDescription;

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        System.out.println("Inside setCuisineName method " + cuisineName);
        this.cuisineName = cuisineName;
    }

    public String getCuisineDescription() {
        return cuisineDescription;
    }

    public void setCuisineDescription(String cuisineDescription) {
        System.out.println("Inside setCuisineName method " + cuisineDescription);
        this.cuisineDescription = cuisineDescription;
    }
}
