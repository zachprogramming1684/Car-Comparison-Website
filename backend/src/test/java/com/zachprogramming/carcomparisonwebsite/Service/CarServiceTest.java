package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.CarSearchCriteria;
import com.zachprogramming.carcomparisonwebsite.Exception.CarNotFoundException;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.Repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest
{
    @Mock
    CarRepository carRepository;
    @InjectMocks
    CarService carService;

    @Test
    void shouldReturnAllCars()
    {
        when(carRepository.findAll()).thenReturn(List.of(new Car(), new Car()));
        List<Car> result = carService.allCars();
        assertEquals(2, result.size());
    }

    @Test
    void shouldGetCarById_WhenExists()
    {
        Car car = new Car();
        car.setId(1L);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car)); // todo: explain this
        Car result = carService.getCarById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void shouldThrowException_WhenCarNotFound()
    {
        when(carRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(CarNotFoundException.class, () -> carService.getCarById(99L));
    }

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

        when(carRepository.save(car)).thenReturn(car);
        Car addedCar = carService.addCar(car);
        assertEquals(car.getId(), addedCar.getId());
    }
}