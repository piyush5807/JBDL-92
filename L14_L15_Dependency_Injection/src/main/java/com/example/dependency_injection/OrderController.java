package com.example.dependency_injection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/v1")
public class OrderController {

    @PostMapping("/track")    // -> /orders/v1/track
    public void trackOrder(){

    }

    @PostMapping("/fulfil") // -> /orders/v1/fulfil
    public void fulfilOrder(){

    }
}
