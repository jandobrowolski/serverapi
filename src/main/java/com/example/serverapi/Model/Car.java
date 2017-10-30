package com.example.serverapi.Model;

import com.example.serverapi.DTO.CarDTO;
import com.example.serverapi.DTO.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private boolean isAvaible;
    private String description;
    private String condition;
    private Long speed;
    private Long xCords;
    private Long yCords;
    public Car(CarDTO carDTO){
        id = carDTO.getId();
        description = carDTO.getDescription();
        isAvaible = carDTO.isAvaible();
        condition = carDTO.getCondition();
        speed = carDTO.getSpeed();
        xCords =carDTO.getXCords();
        yCords = carDTO.getYCords();
    }
    public void updateInformation(CarDTO carDTO){
        description = carDTO.getDescription();
        id = carDTO.getId();
        isAvaible = carDTO.isAvaible();
        condition = carDTO.getCondition();
        speed = carDTO.getSpeed();
        xCords =carDTO.getXCords();
        yCords = carDTO.getYCords();
    }
    public CarDTO makeCarDTO(){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(id);
        carDTO.setDescription(description);
        carDTO.setAvaible(isAvaible);
        carDTO.setCondition(condition);
        carDTO.setXCords(xCords);
        carDTO.setYCords(yCords);
        carDTO.setSpeed(speed);

        return  carDTO;
    }
}
