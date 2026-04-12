package com.example.demo_spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {

    private static Logger logger = LoggerFactory.getLogger(DemoSpringBootApplication.class);

    DemoSpringBootApplication(){
        logger.info("DemoSpringBootApplication object created..");
    }


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
//        System.out.println("Application started....");
//
//
//        logger.error("Application started...");
//        logger.warn("Application started...");
//        logger.info("Application started...");
//        logger.debug("Application started...");
//        logger.trace("Application started...");

        // OOM -

//        logger.warn("Free Memory available - {}, total memory - {}", Runtime.getRuntime().freeMemory(), Runtime.getRuntime().totalMemory());

//        try{
//
//        }catch (Exception e){
//            logger.error("Got exception - {}", e);
//            throw e;
//        }

//        try{
//
//        }catch (Exception e){
//            logger.warn("Got exception - {}", e);
//        }


        /**
         * 1. ERROR - most severe level - conventionally these should be used when you encounter some exceptions - (very few in number almost negligible)
         * 2. WARN - conventionally these should be used when you either encounter an error or there could be chance of an issue coming up in future - (very few in number almost negligible)
         * 3. INFO - informational logs that the developers want to see in normal scenarios as well ( few in number almost negligible - important in nature )
         * 4. DEBUG - People use this logging level to print even minutest of the data that could help in troubleshooting any issues. They are more in number than INFO logs (Huge in number and prints elaborate information)
         * 5. TRACE - least severe level - these logs are used in listener or watcher related scenarios where some sort of heartbeat is emitted by an entity periodically. Ex: servlet (Heartbeats: Kind of infinite in number )
         */


        /**
         * Environments / Stages =>  Dev / Staging / PreProd / UAT => Production
         * Staging / Dev / Preprod ==> DEBUG application level logging
         * Production ==> INFO
         *
         */

        // By default spring boot keeps the application level logging as INFO, so any level equal and above INFO in terms of severity will be printed
    }

}
