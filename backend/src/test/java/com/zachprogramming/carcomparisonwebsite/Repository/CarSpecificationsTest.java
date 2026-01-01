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

    @Test
    void shouldFilterByPriceRange()
    {
        Specification<Car> spec = CarSpecifications.priceLessThan(25000.0);
        List<Car> results = carRepository.findAll(spec);
        assertEquals(2, results.size());
    }

    @Test
    void shouldFilterByModelFuzzySearch()
    {
        Specification<Car> spec = CarSpecifications.modelContains("Civ"); //
        List<Car> results = carRepository.findAll(spec);
        assertEquals(1, results.size());
        assertEquals("Civic", results.get(0).getModel());
    }

    @Test
    void shouldFilterByYearRange()
    {
        Specification<Car> spec = CarSpecifications.betweenYears(2019, 2022); //
        List<Car> results = carRepository.findAll(spec);
        assertEquals(2, results.size()); // Honda (2020) and Ford (2021)
    }

    @Test
    void shouldHandlePartialYearInputs()
    {
        Specification<Car> spec = CarSpecifications.betweenYears(2019, null); //
        List<Car> results = carRepository.findAll(spec);
        assertEquals(2, results.size()); // 2020 and 2021 models
    }
}