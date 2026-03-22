package com.example.intro;

public class Person {

    private String name;
    private Integer id;
    private Integer age;
    private Double weight;
    private Double height;


    // {name = ABC, id = 1, age = 30, weight = 50, height = 6, address: {state: Delhi, country: India} }
    // 50 --> 70

    // PUT - expecting the entire data from frontend so that they can just replace the existing data with the incoming data
    // {name = ABC, id = 1, age = 30, weight = 70, height = 6} - complete data to the backend

    // PATCH - expecting only the modified attributes / changed attributes from frontend, but this time, they need to merge the existing data with the incoming data
    // {weight = 70, address: {state: Bangalore}}
    // Merging: {name = ABC, id = 1, age = 30, weight = 50, height = 6,  address: {state: Delhi, country: India}} with {weight = 70, address: {state: Bangalore}}
}
