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
    private CarRepository carRepository;
    public CarService(CarRepository carRepository) {this.carRepository = carRepository;}

    public List<Car> allCars()
    {
        return carRepository.findAll();
    }

    public Car getCarById(Long id)
    {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car with ID " + id + " not found."));
    }

    public Car addCar(Car car)
    {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails)
    {
        Car existingCar = carRepository.findById(id).orElseThrow(() ->
                new CarNotFoundException("Cannot update. Car with ID " + id + " not found."));

        existingCar.setMake(carDetails.getMake());
        existingCar.setModel(carDetails.getModel());
        existingCar.setYear(carDetails.getYear());
        existingCar.setPrice(carDetails.getPrice());
        existingCar.setColor(carDetails.getColor());
        existingCar.setHorsepower(carDetails.getHorsepower());

        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id)
    {
        if(!carRepository.existsById(id))
        {
            throw new CarNotFoundException("Cannot delete. Car with ID " + id + " not found.");
        }
        carRepository.deleteById(id);
    }

}
