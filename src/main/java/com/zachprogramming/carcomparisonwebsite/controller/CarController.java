package com.zachprogramming.carcomparisonwebsite.controller;

import com.zachprogramming.carcomparisonwebsite.model.Car;
import com.zachprogramming.carcomparisonwebsite.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController
{
    @Autowired
    private CarService carService;

    public CarController(CarService carService) {}

    @GetMapping("/all")
    public List<Car> getAllCars()
    {
        return carService.allCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id)
    {
        return carService.getCarById(id);
    }

    public List<Car> compareCars(@RequestParam Long id1, @RequestParam Long id2)
    {
        Car car1 = carService.getCarById(id1);
        Car car2 = carService.getCarById(id2);

        if(car1 == null && car2 == null)
        {
            throw new UnsupportedOperationException("TODO");
        }

        return Arrays.asList(car1, car2); //TODO: figure out how this works
    }
}
