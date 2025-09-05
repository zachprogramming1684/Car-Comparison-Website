package com.zachprogramming.carcomparisonwebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car
{
    @Id
    private Long id;
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private int horsepower;

    public Car()
    {

    }

    public Car(Long id, String make, String model, int year, String color, double price, int horsepower) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
