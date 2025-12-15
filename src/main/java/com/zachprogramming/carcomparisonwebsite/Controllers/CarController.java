package com.zachprogramming.carcomparisonwebsite.Controllers;

import com.zachprogramming.carcomparisonwebsite.Models.ValueScoreDTO;
import com.zachprogramming.carcomparisonwebsite.Services.CarService;
import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.Models.ComparisonDTO;
import com.zachprogramming.carcomparisonwebsite.Services.ComparisonService;
import com.zachprogramming.carcomparisonwebsite.Services.ValueScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController
{

    private final CarService carService;
    private final ComparisonService comparisonService;
    private final ValueScoreService valueScoreService;

    public CarController(CarService carService,  ComparisonService comparisonService, ValueScoreService valueScoreService)
    {
        this.carService = carService;
        this.comparisonService = comparisonService;
        this.valueScoreService = valueScoreService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {return ResponseEntity.ok(carService.allCars());}

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {return ResponseEntity.ok(carService.getCarById(id));}

    @GetMapping("/compare")
    public ResponseEntity<ComparisonDTO> compareCars(@RequestParam Long id1, @RequestParam Long id2)
    {
        Car car1 = carService.getCarById(id1);
        Car car2 = carService.getCarById(id2);

        ComparisonDTO comparison = comparisonService.compareCars(car1, car2);

        return ResponseEntity.ok(comparison);
    }

    @GetMapping("/valscore")
    public ResponseEntity<ValueScoreDTO> getValueScore(@RequestParam Long id)
    {
        Car car = carService.getCarById(id);
        ValueScoreDTO valueScore = valueScoreService.generateValueScore(car);

        return ResponseEntity.ok(valueScore);
    }
}
