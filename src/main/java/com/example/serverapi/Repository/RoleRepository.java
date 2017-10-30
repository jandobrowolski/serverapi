package com.example.serverapi.Repository;

import com.example.serverapi.Model.Role;
import com.example.serverapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findOneByName(String name);
    Role findOneById(Long id);

}

