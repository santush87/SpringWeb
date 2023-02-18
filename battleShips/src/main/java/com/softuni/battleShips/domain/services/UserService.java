package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.entities.User;
import com.softuni.battleShips.domain.helpers.LoggedUser;
import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.models.UserWithShipsModel;
import com.softuni.battleShips.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public UserModel findByUsername(String username){
        return this.modelMapper.map(
                this.userRepository.
                        findByUsername(username).
                        orElse(new User()),
                UserModel.class);
    }

    public UserModel findById(String id){
        return this.modelMapper.map(
                this.userRepository.
                        findById(id).
                        orElse(new User()),
                UserModel.class);
    }

    public UserModel findByIdNot(String id){
        return this.modelMapper.map(
                this.userRepository.
                        findByIdNot(id).
                        orElse(new User()),
                UserModel.class);
    }
}
