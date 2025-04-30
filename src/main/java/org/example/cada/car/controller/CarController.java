package org.example.cada.car.controller;

import org.example.cada.car.Car;
import org.example.cada.car.service.CarService;
import org.example.cada.carPhoto.model.CarPhoto;
import org.example.cada.carPhoto.service.CarPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @GetMapping("/{carId}")
    public String getCarDetails(@PathVariable Long carId, Model model) {
        Car car = carService.getCarById(carId);
        List<CarPhoto> photos = carPhotoService.getPhotosByCar(carId);
        model.addAttribute("car", car);
        model.addAttribute("photos", photos);
        return "details";
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        return "index";
    }

    @GetMapping("/search")
    public String searchCar(@RequestParam("vin") String vin, Model model) {
        try {
            Car car = carService.getCarByVin(vin);

            List<CarPhoto> photos = carPhotoService.getPhotosByCar(car.getId());

            model.addAttribute("car", car);
            model.addAttribute("photos", photos);

            return "details";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Car with VIN " + vin + " not found.");
            return "index";
        }
    }


    @GetMapping("/uploads/{carId}/photo/{photoId}")
    public String serveFile(@PathVariable Long carId, @PathVariable Long photoId, Model model) {
        CarPhoto carPhoto = carPhotoService.getPhotoById(photoId);
        model.addAttribute("photo", carPhoto);
        return "photo";
    }

    @GetMapping("/car/new")
    public String showCarForm() {
        return "create";
    }

    @PostMapping("/car/new")
    public String createCar(
            @RequestParam("vin") String vin,
            @RequestParam("auctionName") String auctionName,
            @RequestParam("auctionDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date auctionDate,
            @RequestParam("shippingPorts") String shippingPorts,
            @RequestParam("otherDetails") String otherDetails,
            @RequestParam("photos") List<MultipartFile> photos,
            Model model) throws IOException {

        Car car = new Car();
        car.setVin(vin);
        car.setAuctionName(auctionName);
        car.setAuctionDate(auctionDate);
        car.setShippingPorts(shippingPorts);
        car.setOtherDetails(otherDetails);
        carService.save(car);

        for (MultipartFile file : photos) {
            if (!file.isEmpty()) {
                carPhotoService.saveCarPhoto(car.getId(), file);
            }
        }

        model.addAttribute("car", car);

        return "redirect:/car/" + car.getId();
    }
}