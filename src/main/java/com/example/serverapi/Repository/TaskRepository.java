package com.example.serverapi.Repository;

import com.example.serverapi.Model.Car;
import com.example.serverapi.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
      Task findOneById(Long id);

}

