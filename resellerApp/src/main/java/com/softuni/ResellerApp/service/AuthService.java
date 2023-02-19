package com.softuni.ResellerApp.service;

import com.softuni.ResellerApp.model.dtos.UserLoginModel;
import com.softuni.ResellerApp.model.dtos.UserRegisterModel;
import com.softuni.ResellerApp.model.entity.User;
import com.softuni.ResellerApp.repository.UserRepository;
import com.softuni.ResellerApp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public boolean registerUser(UserRegisterModel userRegisterModel){
        Optional<User> userOptional = this.userRepository.findByUsername(userRegisterModel.getUsername());
        if (userOptional.isPresent()) {
            return false;
        }

        Optional<User> emailOptional = this.userRepository.findByEmail(userRegisterModel.getEmail());
        if (emailOptional.isPresent()) {
            return false;
        }

        this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));
        return true;
    }

    public boolean loginUser(UserLoginModel userLoginModel){
        User user = this.userRepository.findByUsernameAndPassword(
                userLoginModel.getUsername(), userLoginModel.getPassword())
                .get();

        if (user.getId() == null){
            return false;
        }

        loggedUser.setId(user.getId());

        return true;


    }

    public void logout(){
        loggedUser.clearUser();
    }
}
