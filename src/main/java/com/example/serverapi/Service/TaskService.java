package com.example.serverapi.Service;

import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.DTO.TaskDTO;
import com.example.serverapi.Model.Driver;
import com.example.serverapi.Model.StaticRoleNames;
import com.example.serverapi.Model.Task;
import com.example.serverapi.Repository.DriverRepository;
import com.example.serverapi.Repository.RoleRepository;
import com.example.serverapi.Repository.TaskRepository;
import com.example.serverapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {

        private final DriverRepository driverRepository;
        private final TaskRepository taskRepository;
        @Autowired
        public TaskService(DriverRepository driverRepository, TaskRepository taskRepository) {
            this.taskRepository= taskRepository;
            this.driverRepository = driverRepository;
        }

        public TaskDTO addTask(TaskDTO taskDTO){
            Driver driver  = driverRepository.findOneById(taskDTO.getDriverId());
            driver.getShedule().add(new Task(taskDTO));
            driverRepository.save(driver);
            return taskDTO;

        }
        public TaskDTO updateTask(TaskDTO taskDTO){
            Task task = taskRepository.findOneById(taskDTO.getId());
            task.updateInformation(taskDTO);
            taskRepository.save(task);
            return taskDTO;

        }
        public TaskDTO getTask(Long id) {
            return this.taskRepository.findOneById(id).makeTaskDTO();
        }

        public void deleteTask(Long id){
            this.deleteTask(this.taskRepository.findOneById(id));
        }
        public void deleteTask(Task task) {
            this.taskRepository.delete(task);
        }

        public List<TaskDTO> getAllTask(){
            List<Task> tasks= taskRepository.findAll();
            LinkedList<TaskDTO> tasksDTO= new LinkedList<>();
            for (Task task:tasks) {
                tasksDTO.add(task.makeTaskDTO());
            }
            return tasksDTO;
        }

}
