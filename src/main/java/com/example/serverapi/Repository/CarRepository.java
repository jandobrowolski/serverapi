package com.example.serverapi.Repository;

import com.example.serverapi.Model.Car;
import com.example.serverapi.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
      Car findOneById(Long id);

}

