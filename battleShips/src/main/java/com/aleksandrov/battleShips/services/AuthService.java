package com.aleksandrov.battleShips.services;

import com.aleksandrov.battleShips.models.User;
import com.aleksandrov.battleShips.models.dtos.UserLoginDto;
import com.aleksandrov.battleShips.models.dtos.UserRegistrationDto;
import com.aleksandrov.battleShips.repositories.UserRepository;
import com.aleksandrov.battleShips.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserSession userSession;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userSession = userSession;
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

    public boolean login(UserLoginDto loginDto) {
        Optional<User> userToLogin = this.userRepository
                .findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());

        if (userToLogin.isEmpty()){
            return false;
        }

        this.userSession.login(userToLogin.get());
        return true;
    }

    public void logout() {
        this.userSession.logout();
    }
}
