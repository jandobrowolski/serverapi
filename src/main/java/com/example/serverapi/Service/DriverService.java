package com.example.serverapi.Service;

import com.example.serverapi.DTO.DriverDTO;
import com.example.serverapi.Model.Driver;
import com.example.serverapi.Model.StaticRoleNames;
import com.example.serverapi.Repository.DriverRepository;
import com.example.serverapi.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DriverService {

        private final DriverRepository driverRepository;
        private final RoleRepository roleRepository;
        @Autowired
        public DriverService(DriverRepository driverRepository, RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
            this.driverRepository = driverRepository;
        }

        public DriverDTO addDriver(DriverDTO driverRegestryDTO){
            Driver driver = new Driver(driverRegestryDTO);
            driver.getRoles().add(roleRepository.findOneByName(StaticRoleNames.USER_ROLE));
            return this.driverRepository.save(driver).makeDriverDTO();

        }
        public DriverDTO updateDriver(DriverDTO driverRegestryDTO){
            Driver driver = this.driverRepository.findOneById(driverRegestryDTO.getId());
            driver.updateInformation(driverRegestryDTO);
            return this.driverRepository.save(driver).makeDriverDTO();

        }
        public DriverDTO getDriver(Long id){
            return this.driverRepository.findOneById(id).makeDriverDTO();
        }

        public void deleteDriver(Long id){
            this.deleteDriver(this.driverRepository.findOneById(id));
        }
        public void deleteDriver(Driver driver){
            this.driverRepository.delete(driver);
        }
        public List<DriverDTO> getAllDrivers(){
            List<Driver> drivers = driverRepository.findAll();
            LinkedList<DriverDTO> driversDTO  = new LinkedList<>();
            for (Driver driver:drivers) {
                driversDTO.add(driver.makeDriverDTO());
            }
            return driversDTO;
        }

}
