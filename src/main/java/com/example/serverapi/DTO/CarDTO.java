package com.example.serverapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private Long id;
    private String description;
    private boolean isAvaible;
    private String condition;
    private Long speed;
    private Long xCords;
    private Long yCords;




}
