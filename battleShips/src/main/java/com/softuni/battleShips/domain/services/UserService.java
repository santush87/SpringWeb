package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.entities.User;
import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserModel findByUsername(String username){
        return this.modelMapper.map(
                this.userRepository.
                        findByUsername(username).
                        orElse(new User()),
                UserModel.class);
    }
}
