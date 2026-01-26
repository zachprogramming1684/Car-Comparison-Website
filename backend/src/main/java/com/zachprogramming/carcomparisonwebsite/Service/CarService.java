package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.CarSearchCriteria;
import com.zachprogramming.carcomparisonwebsite.Exception.CarNotFoundException;
import com.zachprogramming.carcomparisonwebsite.Repository.CarRepository;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.Repository.CarSpecifications;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    private CarRepository carRepository;
    public CarService(CarRepository carRepository) {this.carRepository = carRepository;}

    @Cacheable(value = "cars")
    public List<Car> allCars()
    {
        return carRepository.findAll();
    }

    @Cacheable(value = "cars", key = "#id")
    public Car getCarById(Long id)
    {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car with ID " + id + " not found."));
    }

    public List<Car> searchCars(CarSearchCriteria criteria)
    {
        Specification<Car> spec = Specification.where(null);

        // match criteria to car lookup only if the user has specified certain criteria
        if(criteria.getMake() != null) {spec = spec.and(CarSpecifications.hasMake(criteria.getMake()));}
        if(criteria.getModel() != null) {spec = spec.and(CarSpecifications.modelContains(criteria.getModel()));}
        if(criteria.getMaxPrice() != null) {spec = spec.and(CarSpecifications.priceLessThan(criteria.getMaxPrice()));}
        if(criteria.getColor() != null) {spec = spec.and(CarSpecifications.isColor(criteria.getColor()));}
        if(criteria.getMinHorsepower() != null) {spec = spec.and(CarSpecifications.horsepowerGreaterThan(criteria.getMinHorsepower()));}
        if(criteria.getMinMpg() != null) {spec = spec.and(CarSpecifications.mpgGreaterThan(criteria.getMinMpg()));}
        if(criteria.getMinYear() != null || criteria.getMaxYear() != null) {spec = spec.and(CarSpecifications.betweenYears(criteria.getMinYear(), criteria.getMaxYear()));}
        return carRepository.findAll(spec);
    }

    @CachePut(value = "cars", key = "#car.id")
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
        existingCar.setFuelEconomy(carDetails.getFuelEconomy());
        existingCar.setTrim(carDetails.getTrim());

        return carRepository.save(existingCar);
    }

    @CacheEvict(value = "cars", key = "#id")
    public void deleteCar(Long id)
    {
        if(!carRepository.existsById(id))
        {
            throw new CarNotFoundException("Cannot delete. Car with ID " + id + " not found.");
        }
        carRepository.deleteById(id);
    }

}
