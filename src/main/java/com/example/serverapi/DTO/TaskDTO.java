package com.example.serverapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private Long driverId;
    private Long creatorId;
    private Date creationDate;
    private String description;
    private Integer priority;
    private String status;
    private Integer regionId;


}
