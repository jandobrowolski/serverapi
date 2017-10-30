package com.example.serverapi.Controller;

import com.example.serverapi.DTO.PhotoDTO;
import com.example.serverapi.DTO.TaskDTO;
import com.example.serverapi.Model.Task;
import com.example.serverapi.Service.PhotoService;
import com.example.serverapi.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleAPI {

    private final TaskService taskService;
    @Autowired
    public ScheduleAPI(TaskService taskService) {
        this.taskService= taskService;
    }
    @RequestMapping(value = "task/create",method = RequestMethod.POST)
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }
    @RequestMapping(value = "task/update",method = RequestMethod.POST)
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){
        return taskService.updateTask(taskDTO);
    }
    @RequestMapping(value = "task/get",method = RequestMethod.POST)
    public TaskDTO getTask(@RequestBody TaskDTO taskDTO){
        return taskService.getTask(taskDTO.getId());
    }

    @RequestMapping(value = "task/delete",method = RequestMethod.POST)
    public Boolean deleteTask(@RequestBody TaskDTO taskDTO){
        try {
            taskService.deleteTask(taskDTO.getId());
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @RequestMapping(value = "task/getAll",method = RequestMethod.POST)
    public List<TaskDTO> getAllTask(){
        return taskService.getAllTask();
    }



}
