package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.Repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvDataLoader implements CommandLineRunner
{
    private final CarRepository carRepository;
    public CsvDataLoader(CarRepository carRepository) {this.carRepository = carRepository;}

    @Override
    public void run(String... args) throws Exception
    {
        if(carRepository.count()==0)
        {
            System.out.println("Reading CSV file...");
            loadCsvData();
        }
        else
        {
            System.out.println("Database already contains data. Skipping CSV loading.");
        }
    }

    private void loadCsvData()
    {
        List<Car> cars = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/cars.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
        {
            String line = reader.readLine();

            while((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");
                Car car = new Car(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    Double.parseDouble(data[4]),
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[6]),
                    data[7]
                );
                cars.add(car);
            }

            carRepository.saveAll(cars);
            System.out.println("Successfully loaded " + cars.size() + " cars into the database.");
        }

        catch (IOException e)
        {
            System.out.println("Error loading CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
