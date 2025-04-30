package org.example.cada.car.repository;

import org.example.cada.car.Car;
import org.example.cada.carPhoto.model.CarPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Optional<Car> getCarById(Long id);
    List<Car> findAll();
    CarPhoto getPhotoById(Long id);
    Optional<Car> findByVin(String vin);
}
