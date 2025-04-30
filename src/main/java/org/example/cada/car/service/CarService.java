package org.example.cada.car.service;

import org.example.cada.car.Car;
import org.example.cada.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public Car getCarByVin(String vin) {
        return carRepository.findByVin(vin)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with VIN: " + vin));
    }
}

