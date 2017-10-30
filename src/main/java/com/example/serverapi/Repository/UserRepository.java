package com.example.serverapi.Repository;

import com.example.serverapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User  findOneByUsername(String username);
    User  findOneById(Long id);

}

