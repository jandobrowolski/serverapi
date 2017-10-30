package com.example.serverapi.Repository;

import com.example.serverapi.Model.Car;
import com.example.serverapi.Model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
      Photo findOneById(Long id);

}

