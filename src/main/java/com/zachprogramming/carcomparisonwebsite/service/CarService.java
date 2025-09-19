package com.zachprogramming.carcomparisonwebsite.service;

import com.zachprogramming.carcomparisonwebsite.model.Car;
import com.zachprogramming.carcomparisonwebsite.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return carRepository.findById(id).get(); //TODO: figure out how this works
    }

}
