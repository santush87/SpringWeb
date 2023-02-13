package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.entities.User;
import com.softuni.battleShips.domain.helpers.LoggedUser;
import com.softuni.battleShips.domain.models.binding.UserLoginModel;
import com.softuni.battleShips.domain.models.binding.UserRegisterModel;
import com.softuni.battleShips.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public void registerUser(UserRegisterModel userRegisterModel){
        this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));
    }

    public void loginUser(UserLoginModel userLoginModel){
        User user = this.userRepository.findByUsername(userLoginModel.getUsername()).get();
        loggedUser.setId(user.getId());
    }

    public void logout(){
        loggedUser.clearUser();
    }
}
