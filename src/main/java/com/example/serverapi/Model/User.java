package com.example.serverapi.Model;

import com.example.serverapi.DTO.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="users" ,uniqueConstraints={
        @UniqueConstraint(columnNames={"email","username"}),
})
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Size(min = 5, max = 40)
    String username;
    @Size(min = 5, max = 40)
    String password;
    @Email
    String email;
    @ManyToMany
    List<Role> roles = new LinkedList<>();

    public User(UserDTO userDTO){
        this.username =userDTO.getUsername() ;
        this.email=userDTO.getEmail() ;
        this.password=userDTO.getPassword() ;

    }
}
