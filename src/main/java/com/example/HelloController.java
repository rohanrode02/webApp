package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Web App!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Rohan! Your CI/CD is working!";
    }
}
