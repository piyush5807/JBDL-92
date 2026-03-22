package com.example.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstJBDL92DemoApplicationOnServer {

    private static Logger logger = LoggerFactory.getLogger(FirstJBDL92DemoApplicationOnServer.class);

	public static void main(String[] args) {
		SpringApplication.run(FirstJBDL92DemoApplicationOnServer.class, args);

//        Runnable runnable = () -> logger.info("Inside runnable...");
//        Thread thread = new Thread(runnable);
//        thread.start();

//        Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
//        Statement statement = connection.createStatement();
//        statement.execute("sql");
	}

}
