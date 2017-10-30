package com.example.serverapi.Repository;

import com.example.serverapi.Model.Driver;
import com.example.serverapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
      Driver findOneById(Long id);
}

