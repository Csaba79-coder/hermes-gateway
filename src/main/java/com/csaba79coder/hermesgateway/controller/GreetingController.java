package com.csaba79coder.hermesgateway.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Greeting from Spring - test the rest api
 */
@RestController
@CrossOrigin(origins = "*")
public class GreetingController {

    @GetMapping("/spring/hello/{name}")
    public Map<String, String> sayHello(@PathVariable String name) {
        return Map.of("message", "Hello " + name + " from Spring");
    }

    @GetMapping("/spring/")
    public Map<String, String> root() {
        return Map.of("message", "Hello World from Spring");
    }
}
