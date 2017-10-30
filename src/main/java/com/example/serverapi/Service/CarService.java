package com.example.serverapi.Service;

import com.example.serverapi.DTO.CarDTO;
import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.Model.Car;
import com.example.serverapi.Model.Driver;
import com.example.serverapi.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(CarDTO carDTO) {
        return carRepository.save(new Car(carDTO));
    }

    public Car updateCar(CarDTO carDTO) {
        Car car = carRepository.findOneById(carDTO.getId());
        car.updateInformation(carDTO);
        return this.carRepository.save(car);
    }

    public Car getCar(Long id) {
        return this.carRepository.getOne(id);
    }

    public void deleteCar(Long id) {
        this.deleteCar(carRepository.findOneById(id));
    }

    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        LinkedList<CarDTO> carsDTO = new LinkedList<>();
        for (Car car : cars) {
            carsDTO.add(car.makeCarDTO());
        }
        return carsDTO;
    }

}
