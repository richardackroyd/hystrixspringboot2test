package com.example.circuitbreakerbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class CircuitBreakerBookstoreApplication {

  Logger logger = LoggerFactory.getLogger(CircuitBreakerBookstoreApplication.class);

  @RequestMapping(value = "/recommended")
  public String readingList(){
    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
  }

  @RequestMapping(value = "/recommended-delayed")
  public String readingListWithDelay(){
    try {
      Thread.sleep(6000);
    } catch (Exception e) {logger.error("Failed adding a delay to the response");}
    return "I'm a delayed response: Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
  }

  public static void main(String[] args) {
    SpringApplication.run(CircuitBreakerBookstoreApplication.class, args);
  }
}
