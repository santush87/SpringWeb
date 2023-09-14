package com.aleksandrov.battleShips.services;

import com.aleksandrov.battleShips.models.User;
import com.aleksandrov.battleShips.models.dtos.UserRegistrationDto;
import com.aleksandrov.battleShips.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean register(UserRegistrationDto registrationDto) {
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            return false;
        }

        //Check for duplicate email
        Optional<User> byEmail = this.userRepository.findByEmail(registrationDto.getEmail());
        if (byEmail.isPresent()){
            return false;
        }

        //Check for duplicate username
        Optional<User> byUsername = this.userRepository.findByUsername(registrationDto.getUsername());
        if (byUsername.isPresent()){
            return false;
        }

        User userToSave = this.modelMapper.map(registrationDto, User.class);

        this.userRepository.save(userToSave);
        return true;
    }
}
