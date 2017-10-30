package com.example.serverapi.Service;

import com.example.serverapi.Model.Role;
import com.example.serverapi.Model.StaticRoleNames;
import com.example.serverapi.Model.User;
import com.example.serverapi.Repository.RoleRepository;
import com.example.serverapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        @Autowired
        public UserService(UserRepository userRepository,RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
            this.userRepository = userRepository;
        }

        public User addUser(User user){
            user.getRoles().add(roleRepository.findOneByName(StaticRoleNames.USER_ROLE));
            return  this.userRepository.save(user);
        }

        public User editUser(User user){
            return this.userRepository.save(user);
        }
        public void deleteUser(User user){
            this.userRepository.delete(user);
        }
        public List<User> getAllUsers(){
            return userRepository.findAll();
        }
        public User findByUsername(String username){
            return  this.userRepository.findOneByUsername(username);
        }

}
