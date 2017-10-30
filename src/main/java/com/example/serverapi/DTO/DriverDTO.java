package com.example.serverapi.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
@Getter
@Setter

public class DriverDTO {
    private Long id=null;
    private String name;
    private String surname;
    private boolean isMale;
    private Long pesel;
    private Long phoneNumber;
    private String username ;
    private String password;
    @Email
    private String email;

}
