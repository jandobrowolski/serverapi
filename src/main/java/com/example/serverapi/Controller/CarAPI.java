package com.example.serverapi.Controller;

import com.example.serverapi.DTO.CarDTO;
import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.Model.Car;
import com.example.serverapi.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarAPI {
    private final CarService carService;
    @Autowired
    public CarAPI(CarService carService) {
        this.carService= carService;
    }

    @RequestMapping(value = "car/create",method = RequestMethod.POST)
    public CarDTO createCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO).makeCarDTO();
    }
    @RequestMapping(value = "car/update",method = RequestMethod.POST)
    public CarDTO updateCar(@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO).makeCarDTO();
    }

    @RequestMapping(value = "car/get",method = RequestMethod.POST)
    public CarDTO getCar(@RequestBody CarDTO carDTO){
        return carService.getCar(carDTO.getId()).makeCarDTO();
    }


    @RequestMapping(value = "car/delete",method = RequestMethod.POST)
    public Boolean deleteCar(@RequestBody CarDTO carDTO){
        try {
            carService.deleteCar(carDTO.getId());
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @RequestMapping(value = "car/getAll",method = RequestMethod.POST)
    public List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }


}
