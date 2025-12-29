package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.Repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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