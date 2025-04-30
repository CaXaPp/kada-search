package org.example.cada.carPhoto.repository;

import org.example.cada.carPhoto.model.CarPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPhotoRepository extends CrudRepository<CarPhoto, Long> {
    List<CarPhoto> findByCarId(Long carId);
}
