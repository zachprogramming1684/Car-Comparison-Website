package com.zachprogramming.carcomparisonwebsite;

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
        return carRepository.findById(id).orElseThrow(); //TODO: figure out how this works
    }

    public ComparisonDTO compareCars(Car car1, Car car2)
    {
        ComparisonDTO compare = new ComparisonDTO();

        compare.addName(car1.getFullName());
        compare.addName(car2.getFullName());

        Long priceWinner = null;
        if(car1.getPrice() < car2.getPrice()) {priceWinner = car1.getId();}
        else if(car2.getPrice() < car1.getPrice()) {priceWinner = car2.getId();}
        compare.addDifference(new DifferenceDTO("Price", car1.getPrice(), car2.getPrice(), priceWinner));

        Long horsepowerWinner = null;
        if(car1.getHorsepower() < car2.getHorsepower()) {horsepowerWinner = car1.getId();}
        else if(car2.getHorsepower() < car1.getHorsepower()) {horsepowerWinner = car2.getId();}
        compare.addDifference(new DifferenceDTO("Horsepower", car1.getHorsepower(), car2.getHorsepower(), horsepowerWinner));

        compare.setPriceSummary(generatePriceSummary(car1, car2, priceWinner));

        return compare;
    }

    public String generatePriceSummary(Car car1, Car car2, Long paramId)
    {
        if(car1.getId().equals(paramId))
        {
            double diff = car2.getPrice() - car1.getPrice();
            return "There is a $" + diff + " savings in going with the " + car1.getFullName() + " over the " + car2.getFullName() + ".";
        }
        else if(car2.getId().equals(paramId))
        {
            double diff = car1.getPrice() - car2.getPrice();
            return "There is a $" + diff + " savings in going with the " + car2.getFullName() + " over the " + car1.getFullName() + ".";
        }
        return "These cars have equal prices.";
    }
}
