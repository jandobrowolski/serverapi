package com.example.serverapi.Controller;

import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriversAPI {

    private final DriverService driverService;
    @Autowired
    public DriversAPI(DriverService driverService) {
        this.driverService= driverService;
    }

    @RequestMapping(value = "driver/create",method = RequestMethod.POST)
    public DriverDTO createDriver(@RequestBody DriverDTO driverRegestryDTO){
        return driverService.addDriver(driverRegestryDTO);
    }
    @RequestMapping(value = "driver/update",method = RequestMethod.POST)
    public DriverDTO updateDriver(@RequestBody DriverDTO driverRegestryDTO){
        return driverService.updateDriver(driverRegestryDTO);
    }

    @RequestMapping(value = "driver/get",method = RequestMethod.POST)
    public DriverDTO getDriver(@RequestBody DriverDTO driverRegestryDTO){
        return driverService.getDriver(driverRegestryDTO.getId());
    }


    @RequestMapping(value = "driver/delete",method = RequestMethod.POST)
    public Boolean deleteDriver(@RequestBody DriverDTO driverDTO){
        try {
            driverService.deleteDriver(driverDTO.getId());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "driver/getAll",method = RequestMethod.POST)
    public List<DriverDTO> getAllDrivers(){
        return driverService.getAllDrivers();
    }

}
