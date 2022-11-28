package com.ob.ejercicio3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String holaMundo() {
        return "Hello world!!";
    }

    @GetMapping("/data")
    public String authRequired() {
        return "Approved access";
    }
}
