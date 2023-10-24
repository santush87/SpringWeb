package com.example.DictionaryApp.service;

import com.example.DictionaryApp.model.dtos.UserLoginDto;
import com.example.DictionaryApp.model.dtos.UserRegisterDto;
import com.example.DictionaryApp.model.entity.UserEntity;
import com.example.DictionaryApp.repo.UserRepository;
import com.example.DictionaryApp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public boolean register(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and Confirm password must match!");
        }

        boolean existsByUsernameOrEmail = userRepository.existsByUsernameOrEmail(
                userRegisterDto.getUsername(),
                userRegisterDto.getEmail());

        if (existsByUsernameOrEmail) {
            throw new IllegalArgumentException("Email or username already exists! Try another one!");
        }

        UserEntity user = this.modelMapper.map(userRegisterDto, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(user);
        this.loggedUser.login(user.getUsername());

        return true;
    }

    public boolean login(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        UserEntity user = this.userRepository.findByUsername(username);

        if (user != null
                && this.passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            this.loggedUser.login(username);
            return true;
        }
        throw new IllegalArgumentException("Wrong username or password");
    }

    public void logout() {
        this.loggedUser.logout();
    }
}

