package com.zachprogramming.carcomparisonwebsite.Repository;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car,Long>, JpaSpecificationExecutor<Car> {}
