package com.zachprogramming.carcomparisonwebsite.Repository;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarSpecificationsTest
{
    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp()
    {
        carRepository.deleteAll();
        Car honda = new Car("Honda", "Civic", 2020, "White", 20000, 158, 34, "EX");
        Car ford = new Car("Ford", "Mustang", 2021, "Blue", 30000, 450, 19, "GT");
        Car toyota = new Car("Toyota", "Camry", 2018, "Red", 18000, 203, 29, "LE");
        carRepository.saveAll(List.of(honda, ford, toyota));
    }

    @Test
    void shouldFilterByMake()
    {
        Specification<Car> spec = CarSpecifications.hasMake("Honda");
        List<Car> results = carRepository.findAll(spec);
        assertEquals(1, results.size());
        assertEquals("Honda", results.get(0).getMake());
    }
}