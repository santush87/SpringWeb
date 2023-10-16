package com.resellerapp.service;

import com.resellerapp.model.dtos.UserRegisterDto;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterDto userRegisterDto){

        if (userRegisterDto == null){
            return;
        }

        Optional<UserEntity> optUser =
                this.userRepository.findByEmail(userRegisterDto.getEmail());

        if (optUser.isPresent()){
//            throw new IllegalArgumentException("User already exists!");
            return;
        }


        UserEntity userToSave = this.modelMapper.map(userRegisterDto, UserEntity.class);

        userToSave.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepository.save(userToSave);
    }

}
