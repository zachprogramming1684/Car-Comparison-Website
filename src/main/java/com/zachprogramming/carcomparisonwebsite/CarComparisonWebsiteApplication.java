package com.zachprogramming.carcomparisonwebsite;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.Repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarComparisonWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarComparisonWebsiteApplication.class, args);
    }


    // this class lets me add dummy data to the database for testing
    @Bean
    CommandLineRunner initDatabase(CarRepository carRepository)
    {
        return args ->
        {
            carRepository.save(new Car("Honda", "Civic", 2020, "White", 20000, 158));
            carRepository.save(new Car("Nissan", "Rogue", 2013, "Black", 1500, 170));
            carRepository.save(new Car("Ford", "Fusion", 2016, "White", 17000, 230));
            carRepository.save(new Car("Ford", "Mustang", 2025, "Black", 45000, 460));
            carRepository.save(new Car("Toyota", "Supra", 1996, "Blue", 20000, 1000));
        };
    }
}
