package com.example.serverapi.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;
@Getter
@Setter
public class PhotoDTO {
    private Long id;
    private Long xCoords;
    private Long yCoords;
    private Date creationDate;
    private Blob file;
}
