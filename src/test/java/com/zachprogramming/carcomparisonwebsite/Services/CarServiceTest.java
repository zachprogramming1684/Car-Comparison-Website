package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.Repositories.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest
{
    @Mock
    CarRepository carRepository;
    @InjectMocks
    CarService carService;

    @Test
    void addCarShouldAddCarSuccessfully()
    {
        System.out.println("Inside myFirstTest() method");
        Car car = new Car();
        car.setId(1L);
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear(2020);
        car.setColor("White");
        car.setPrice(20000);
        car.setHorsepower(158);
        car.setFuelEconomy(34);
        car.setTrim("LX");

        // basically when something it attempted to be saved to the database, return a car object instead of null since
        // we are not actually saving anything to the database within a test
        Mockito.when(carRepository.save(car)).thenReturn(car);

        Car addedCar = carService.addCar(car);

        // test if product == matched product
        Assertions.assertEquals(car.getId(), addedCar.getId());

    }
}