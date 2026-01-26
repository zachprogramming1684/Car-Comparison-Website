package com.zachprogramming.carcomparisonwebsite.Controller;

import com.zachprogramming.carcomparisonwebsite.DTO.CarSearchCriteria;
import com.zachprogramming.carcomparisonwebsite.DTO.DepreciationDTO;
import com.zachprogramming.carcomparisonwebsite.DTO.ValueScoreDTO;
import com.zachprogramming.carcomparisonwebsite.Service.CarService;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.DTO.ComparisonDTO;
import com.zachprogramming.carcomparisonwebsite.Service.ComparisonService;
import com.zachprogramming.carcomparisonwebsite.Service.DepreciationService;
import com.zachprogramming.carcomparisonwebsite.Service.ValueScoreService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
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
    private final DepreciationService depreciationService;

    public CarController(CarService carService,  ComparisonService comparisonService, ValueScoreService valueScoreService, DepreciationService depreciationService)
    {
        this.carService = carService;
        this.comparisonService = comparisonService;
        this.valueScoreService = valueScoreService;
        this.depreciationService = depreciationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {return ResponseEntity.ok(carService.allCars());}

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {return ResponseEntity.ok(carService.getCarById(id));}

    @GetMapping
    public ResponseEntity<List<Car>> searchCars(@ParameterObject @ModelAttribute CarSearchCriteria criteria)
    {
        return ResponseEntity.ok(carService.searchCars(criteria));
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@ParameterObject @ModelAttribute @RequestBody Car car)
    {
        Car newCar = carService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@ParameterObject @ModelAttribute @PathVariable Long id, @RequestBody Car car)
    {
        Car updatedCar = carService.updateCar(id, car);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteCar(@PathVariable Long id)
    {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/compare")
    public ResponseEntity<ComparisonDTO> compareCars(@RequestParam Long id1, @RequestParam Long id2)
    {
        Car car1 = carService.getCarById(id1);
        Car car2 = carService.getCarById(id2);

        ComparisonDTO comparison = comparisonService.compareCars(car1, car2);

        return ResponseEntity.ok(comparison);
    }

    @GetMapping("/{id}/valuescore")
    public ResponseEntity<ValueScoreDTO> getValueScore(@PathVariable Long id)
    {
        Car car = carService.getCarById(id);
        ValueScoreDTO valueScore = valueScoreService.generateValueScore(car);

        return ResponseEntity.ok(valueScore);
    }

    @GetMapping("/{id}/depreciation")
    public ResponseEntity<DepreciationDTO> getDepreciation(@PathVariable Long id)
    {
        Car car = carService.getCarById(id);
        DepreciationDTO depreciation = depreciationService.calculateDepreciation(car, 5);
        return ResponseEntity.ok(depreciation);
    }


}
