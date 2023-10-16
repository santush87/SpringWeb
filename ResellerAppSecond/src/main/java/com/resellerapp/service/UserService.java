package com.resellerapp.service;

import com.resellerapp.model.dtos.UserLoginDto;
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
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    public void register(UserRegisterDto userRegisterDto) {

        if (userRegisterDto == null) {
            return;
        }

        Optional<UserEntity> optUser =
                this.userRepository.findByEmail(userRegisterDto.getEmail());

        if (optUser.isPresent()) {
//            throw new IllegalArgumentException("User already exists!");
            return;
        }


        UserEntity userToSave = this.modelMapper.map(userRegisterDto, UserEntity.class);

        userToSave.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepository.save(userToSave);
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> optUser =
                this.userRepository.findByUsername(userLoginDto.getUsername());

        if (optUser != null && this.passwordEncoder
                .matches(userLoginDto.getPassword(), optUser.get().getPassword())) {

            this.loggedUser.setUsername(optUser.get().getUsername());
            this.loggedUser.setLogged(true);
            return true;
        }
        return false;

    }

    public void logout() {
        this.loggedUser.setUsername(null);
        this.loggedUser.setLogged(false);
    }
}
