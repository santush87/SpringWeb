package com.plannerapp.service;

import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;


    public boolean register(UserRegisterDto userRegisterDto) {
        Optional<UserEntity> optUser =
                this.userRepository.findByUsername(userRegisterDto.getUsername());

        if (optUser.isPresent()){
            throw new IllegalArgumentException("Email or username already exists! Try another one!");
        }

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            throw new IllegalArgumentException("Password and Confirm password must match!");
        }

        UserEntity userToSave = this.modelMapper.map(userRegisterDto, UserEntity.class);
        userToSave.setPassword(this.passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepository.save(userToSave);
        this.loggedUser.setUsername(userRegisterDto.getUsername());
        this.loggedUser.setLogged(true);

        return true;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> optUser = this.userRepository.findByUsername(userLoginDto.getUsername());
        if (optUser.isPresent()){
            if (this.passwordEncoder.matches(userLoginDto.getPassword(), optUser.get().getPassword())){
                this.loggedUser.setUsername(userLoginDto.getUsername());
                this.loggedUser.setLogged(true);
                return true;
            } else {
                throw new IllegalArgumentException("Wrong username or password");
            }
        }
        return false;
    }
}
