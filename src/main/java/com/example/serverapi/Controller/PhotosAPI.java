package com.example.serverapi.Controller;

import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.DTO.PhotoDTO;
import com.example.serverapi.Service.DriverService;
import com.example.serverapi.Service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotosAPI {

    private final PhotoService photoService;
    @Autowired
    public PhotosAPI(PhotoService photoService) {
        this.photoService= photoService;
    }
//
//    @RequestMapping(value = "user/add",method = RequestMethod.POST)
//    public User addUser(@RequestBody UserDTO userDTO){
//        return userService.addUser(new User(userDTO));
//    }
    @RequestMapping(value = "photo/create",method = RequestMethod.POST)
    public PhotoDTO createPhoto(@RequestBody PhotoDTO photoDTO){
        return photoService.addPhoto(photoDTO);
    }
    @RequestMapping(value = "photo/update",method = RequestMethod.POST)
    public PhotoDTO updatePhoto(@RequestBody PhotoDTO photoDTO){
        return photoService.updatePhoto(photoDTO);
    }

    @RequestMapping(value = "photo/get",method = RequestMethod.POST)
    public PhotoDTO getPhoto(@RequestBody PhotoDTO photoDTO){
        return photoService.getPhoto(photoDTO.getId());
    }

    @RequestMapping(value = "photo/delete",method = RequestMethod.POST)
    public Boolean deletePhoto(@RequestBody PhotoDTO photoDTO){
        try {
            photoService.deletePhoto(photoDTO.getId());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "photo/getAll",method = RequestMethod.POST)
    public List<PhotoDTO> getAllPhotos(){
        return photoService.getAllPhotos();
    }

}