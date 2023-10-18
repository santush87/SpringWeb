package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.UserLoginDto;
import com.example.spotifyplaylistapp.model.dtos.UserRegisterDto;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.util.LoggedUser;
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
            return false;
        }

        boolean existsByUsernameOrEmail = userRepository.existsByUsernameOrEmail(
                userRegisterDto.getUsername(),
                userRegisterDto.getEmail());

        if (existsByUsernameOrEmail) {
            return false;
        }

        UserEntity user = this.modelMapper.map(userRegisterDto, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(user);
        this.loggedUser.login(user.getUsername());

        return true;
    }

    public boolean login(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        UserEntity user = userRepository.findByUsername(username);

        if (user != null
                && this.passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            this.loggedUser.login(username);
            return true;
        }
        return false;
    }

    public void logout() {
        this.loggedUser.logout();
    }
}