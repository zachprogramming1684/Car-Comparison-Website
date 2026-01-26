package com.zachprogramming.carcomparisonwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching
public class CarComparisonWebsiteApplication {
    public static void main(String[] args) {SpringApplication.run(CarComparisonWebsiteApplication.class, args);}
}
