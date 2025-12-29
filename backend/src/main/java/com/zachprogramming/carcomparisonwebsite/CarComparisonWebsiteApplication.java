package com.zachprogramming.carcomparisonwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarComparisonWebsiteApplication {

    public static void main(String[] args) {SpringApplication.run(CarComparisonWebsiteApplication.class, args);}


//    // this class lets me add dummy data to the database for testing
//    @Bean
//    CommandLineRunner initDatabase(CarRepository carRepository)
//    {
//        return args ->
//        {
//            if(carRepository.count()==0)
//            {
//                carRepository.save(new Car("Honda", "Civic", 2020, "White", 20000, 158, 34, "LX"));
//                carRepository.save(new Car("Nissan", "Rogue", 2013, "Black", 1500, 170, 25, "S"));
//                carRepository.save(new Car("Ford", "Fusion", 2016, "White", 17000, 230, 25, "Titanium"));
//                carRepository.save(new Car("Ford", "Mustang", 2025, "Black", 45000, 460, 18, "Premium"));
//                carRepository.save(new Car("Toyota", "Supra", 1996, "Blue", 20000, 1000, 15, "Sport"));
//                carRepository.save(new Car("Ford", "F-150", 2025, "White", 40000, 400, 18, "super"));
//                carRepository.save(new Car("Toyota", "Prius", 2020, "Red", 25000, 120, 52, "Base"));
//            }
//            else
//            {
//                System.out.println("Database already contains cars. Skipping...");
//            }
//        };
//    }
}
