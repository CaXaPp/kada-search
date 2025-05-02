package org.example.cada.carPhoto.service;

import org.example.cada.car.Car;
import org.example.cada.car.repository.CarRepository;
import org.example.cada.carPhoto.model.CarPhoto;
import org.example.cada.carPhoto.repository.CarPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarPhotoService {

    @Autowired
    private CarPhotoRepository carPhotoRepository;

    @Autowired
    private CarRepository carRepository;

    public void saveCarPhoto(Long carId, MultipartFile file) throws IOException {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + carId));

        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setCar(car);
//        carPhoto.setFileName(file.getOriginalFilename());
        carPhoto.setPhotoData(file.getBytes());
        carPhoto.setUploadedAt(LocalDateTime.now());

        carPhotoRepository.save(carPhoto);
    }


    public List<CarPhoto> getPhotosByCar(Long carId) {
        return carPhotoRepository.findByCarId(carId);
    }

    public CarPhoto getPhotoById(Long photoId) {
        return carRepository.getPhotoById(photoId);
    }
}