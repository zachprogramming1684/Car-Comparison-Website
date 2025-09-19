package com.zachprogramming.carcomparisonwebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController
{
    @GetMapping("/all")
    public String sayHello()
    {
        return "Hello, World";
    }




}
