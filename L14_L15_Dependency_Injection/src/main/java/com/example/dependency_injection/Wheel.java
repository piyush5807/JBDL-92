package com.example.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class Wheel {

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
