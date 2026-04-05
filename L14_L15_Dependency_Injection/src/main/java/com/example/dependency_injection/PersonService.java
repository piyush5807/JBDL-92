package com.example.dependency_injection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PersonService {

    // Combination of bean name + where they will be used (in which they will be autowired) ==> unique bean id kind of

    PersonService(){
        System.out.println("person service - " + this);
    }

    public void random(){

    }


    // During the application startup
    // v1 - com.example.dependency_injection.PersonService@6aba5d30
    // v2 - com.example.dependency_injection.PersonService@459cfcca

    // During API invocation
    // v1 - person service - com.example.dependency_injection.PersonService@6aba5d30
    // v2 - person service - com.example.dependency_injection.PersonService@459cfcca

}
