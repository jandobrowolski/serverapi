package com.example.serverapi.Model;

import com.example.serverapi.DTO.PhotoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private Long xCoords;
    private Long yCoords;
    private Date creationDate;
    private Blob file;
    public Photo(PhotoDTO photoDTO){
        this.creationDate = photoDTO.getCreationDate();
        this.xCoords = photoDTO.getXCoords();
        this.yCoords =photoDTO.getYCoords();
        this.file =photoDTO.getFile();
    }

    public void updateInformation(PhotoDTO photoDTO){
        this.id = photoDTO.getId();
        this.creationDate = photoDTO.getCreationDate();
        this.xCoords = photoDTO.getXCoords();
        this.yCoords =photoDTO.getYCoords();
        this.file =photoDTO.getFile();
    }

    public PhotoDTO makePhotoDTO(){
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setFile(file);
        photoDTO.setCreationDate(creationDate);
        photoDTO.setId(id);
        photoDTO.setXCoords(xCoords);
        photoDTO.setYCoords(yCoords);
        return photoDTO;
    }


}
