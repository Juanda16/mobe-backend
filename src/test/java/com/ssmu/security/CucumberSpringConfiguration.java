// package com.ssmu.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.test.web.server.LocalServerPort;

// import io.cucumber.spring.CucumberContextConfiguration;
// import jakarta.annotation.PostConstruct;

// @CucumberContextConfiguration
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class CucumberSpringConfiguration {

//     @LocalServerPort
//     private int port;

//     @Autowired
//     protected TestRestTemplate testRestTemplate;

//     @PostConstruct
//     public void setup() {
//         System.setProperty("port", String.valueOf(port));
//     }

// }
