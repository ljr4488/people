package com.example.people.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.people.domain.Person;

@RestController
public class HelloWorld {

	@PostMapping(value="api/Hello")
	//@GetMapping(value="api/Hello")
	public String HelloWorld() {
		Person person;
		return "Hello World";
	}
}
