package com.example.dependency_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "ds")
public class DemoService {

    private static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public DemoService(){
        logger.info("DemoService being initialized... this - {}", this);
    }

}

// com.example.dependency_injection.DemoService@7df76d99

// demoService being used in demo controller... null
