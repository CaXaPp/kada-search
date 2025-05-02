package org.example.cada.carPhoto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cada.car.Car;
import org.example.cada.config.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "car_photos")
public class CarPhoto extends BaseEntity {

    @JoinColumn(name = "car_id")
    @ManyToOne
    private Car car;

    @Lob
    @Column(name = "photo_data", columnDefinition = "BYTEA")
    private byte[] photoData;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
