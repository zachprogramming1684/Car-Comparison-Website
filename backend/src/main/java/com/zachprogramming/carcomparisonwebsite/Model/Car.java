package com.zachprogramming.carcomparisonwebsite.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // this will automatically generate an id for each car added to the database
    private Long id;
    private String make;
    private String model;
    private int modelYear;
    private String color;
    private double price;
    private int horsepower;
    private int fuelEconomy;
    private String trim;

    public Car()
    {

    }

    public Car(String make, String model, int modelYear, String color, double price, int horsepower, int fuelEconomy, String trim) {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.color = color;
        this.price = price;
        this.horsepower = horsepower;
        this.fuelEconomy = fuelEconomy;
        this.trim = trim;
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
        return modelYear;
    }

    public void setYear(int modelYear) {
        this.modelYear = modelYear;
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

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public int getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(int fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getFullName()
    {
        return modelYear + " " + make + " " + model + " " + trim;
    }


}
