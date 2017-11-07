package com.example.serverapi.Model;

import com.example.serverapi.DTO.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="drivers" ,uniqueConstraints={
        @UniqueConstraint(columnNames={"pesel"}),
})
public class Driver extends User {

    private String name;
    private String surname;
    private boolean isMale;
    private Long pesel;
    private Long phoneNumber;
//    @OneToMany
//    private List<Photo> photos;

    @OneToMany
    List<Task> shedule = new LinkedList<>();

    public Driver(DriverDTO driverRegestryDTO) {
        this.name = driverRegestryDTO.getName();
        this.surname = driverRegestryDTO.getSurname();
        this.isMale = driverRegestryDTO.isMale();
        this.pesel = driverRegestryDTO.getPesel();
        this.phoneNumber = driverRegestryDTO.getPhoneNumber();
        super.email = driverRegestryDTO.getEmail();
        super.password = driverRegestryDTO.getPassword();
        super.username = driverRegestryDTO.getUsername();
    }

    public void updateInformation(DriverDTO driverRegestryDTO) {
        this.name = driverRegestryDTO.getName();
        this.surname = driverRegestryDTO.getSurname();
        this.isMale = driverRegestryDTO.isMale();
        this.pesel = driverRegestryDTO.getPesel();
        this.phoneNumber = driverRegestryDTO.getPhoneNumber();
        super.email = driverRegestryDTO.getEmail();
        super.password = driverRegestryDTO.getPassword();
        super.username = driverRegestryDTO.getUsername();
    }
    public DriverDTO makeDriverDTO(){
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setEmail(this.getEmail());
        driverDTO.setMale(this.getMale());
        driverDTO.setId(this.getId());
        driverDTO.setUsername(super.username);
        driverDTO.setPesel(pesel);
        driverDTO.setPhoneNumber(phoneNumber);
        driverDTO.setName(name);
        driverDTO.setSurname(surname);

        return  driverDTO;
    }
}
