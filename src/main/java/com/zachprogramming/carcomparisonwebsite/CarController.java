package com.zachprogramming.carcomparisonwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/compare")
    public ResponseEntity<ComparisonDTO> compareCars(@RequestParam Long id1, @RequestParam Long id2)
    {
        Car car1 = carService.getCarById(id1);
        Car car2 = carService.getCarById(id2);

        ComparisonDTO comparison = carService.compareCars(car1, car2);

        return ResponseEntity.ok(comparison);
    }
}
