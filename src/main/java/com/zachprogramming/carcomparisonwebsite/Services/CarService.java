package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.Exceptions.CarNotFoundException;
import com.zachprogramming.carcomparisonwebsite.Repositories.CarRepository;
import com.zachprogramming.carcomparisonwebsite.Models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    @Autowired
    private CarRepository carRepository;
    public CarService(CarRepository carRepository) {}

    public List<Car> allCars()
    {
        return carRepository.findAll();
    }

    public Car getCarById(Long id)
    {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car with ID " + id + " not found."));
    }

}
