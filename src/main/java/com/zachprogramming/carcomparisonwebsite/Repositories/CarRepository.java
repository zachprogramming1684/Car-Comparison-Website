package com.zachprogramming.carcomparisonwebsite.Repositories;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {}
