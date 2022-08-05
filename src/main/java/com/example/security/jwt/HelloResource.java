package com.example.security.jwt;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloResource {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
