package com.zachprogramming.carcomparisonwebsite.repository;

import com.zachprogramming.carcomparisonwebsite.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long>
{

}
