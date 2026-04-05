package com.example.dependency_injection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Engine {

    private String model;
    private Long yearOfProduction;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Long yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
