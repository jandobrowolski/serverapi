package com.example.serverapi.Service;

import com.example.serverapi.DTO.CarDTO;
import com.example.serverapi.DTO.PhotoDTO;
import com.example.serverapi.Model.Car;
import com.example.serverapi.Model.Photo;
import com.example.serverapi.Repository.CarRepository;
import com.example.serverapi.Repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public PhotoDTO addPhoto(PhotoDTO photoDTO) {
        return photoRepository.save(new Photo(photoDTO)).makePhotoDTO();
    }

    public PhotoDTO updatePhoto(PhotoDTO photoDTO) {
        Photo photo = photoRepository.findOneById(photoDTO.getId());
        photo.updateInformation(photoDTO);
        return this.photoRepository.save(photo).makePhotoDTO();
    }

    public PhotoDTO getPhoto(Long id) {
        return this.photoRepository.getOne(id).makePhotoDTO();
    }

    public void deletePhoto(Long id) {
        this.deletePhoto(photoRepository.findOneById(id));
    }

    public void deletePhoto(Photo photo) {
        photoRepository.delete(photo);
    }

    public List<PhotoDTO> getAllPhotos() {
        List<Photo> photos= photoRepository.findAll();
        LinkedList<PhotoDTO> photosDTO= new LinkedList<>();
        for (Photo photo : photos) {
            photosDTO.add(photo.makePhotoDTO());
        }
        return photosDTO;
    }

}
