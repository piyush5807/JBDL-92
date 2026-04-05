package com.example.dependency_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

//@Component // can be used only on top of classes / enums / interfaces
@Configuration
@Scope("prototype")
public class CustomBean {

    @Bean // can be used only on top of functions
//    @Scope("prototype")
//    @Component
    public Person getPerson(){
        Person person = new Person();
        System.out.println("Inside getPerson.... instance = " + person);
        return person;
    }

//    @Bean
//    @Primary
////    @Scope("singleton")
//    public Person getPerson2(){
//        Person person = new Person();
//        System.out.println("Inside getPerson2.... instance = " + person);
//        return person;
//    }

}
