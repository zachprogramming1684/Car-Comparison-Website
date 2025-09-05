package com.zachprogramming.carcomparisonwebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController
{
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello, World";
    }




}
