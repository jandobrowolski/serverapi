package com.example.serverapi.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

@Getter
@Setter
public class UserDTO {

    private String username ;
    private String password;
    @Email
    private String email;



}
