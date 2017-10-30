package com.example.serverapi.Model;

import com.example.serverapi.DTO.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private Long driverId;

    private Long creatorId;
    private Date creationDate;
    private String description;
    private Integer priority;
    private String status;
    private Integer regionId;

    public Task(TaskDTO taskDTO){
        creatorId = taskDTO.getCreatorId();
        creationDate = taskDTO.getCreationDate();
        description =taskDTO.getDescription();
        priority = taskDTO.getPriority();
        status  = taskDTO.getStatus();
        regionId = taskDTO.getRegionId();
    }

    public void updateInformation(TaskDTO taskDTO){
        creationDate =taskDTO.getCreationDate();
        description = taskDTO.getDescription();
        priority = taskDTO.getPriority();
        status = taskDTO.getStatus();
        regionId = taskDTO.getRegionId();
    }
    public TaskDTO makeTaskDTO(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCreationDate(creationDate);
        taskDTO.setCreatorId(creatorId);
        taskDTO.setDescription(description);
        taskDTO.setDriverId(driverId);
        taskDTO.setPriority(priority);
        taskDTO.setRegionId(regionId);
        taskDTO.setStatus(status);
        return taskDTO;
    }
}
