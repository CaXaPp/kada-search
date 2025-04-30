package org.example.cada.car;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.cada.carPhoto.model.CarPhoto;
import org.example.cada.config.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Column(name = "vin")
    private String vin;

    @Column(name = "auction_name")
    private String auctionName;

    @Column(name = "auction_date")
    private Date auctionDate;

    @Column(name = "shipping_ports")
    private String shippingPorts;

    @Column(name = "other_details")
    private String otherDetails;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarPhoto> photos = new ArrayList<>();
}
