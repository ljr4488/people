package com.example.people.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @GetMapping(value = "/api/Hello")
    public String HelloWorld() {
        return "HelloWorld";
    }

    @GetMapping(value = "/api/World")
    public String PeopleWorld() { return "PeoPleWorld"; }
}
