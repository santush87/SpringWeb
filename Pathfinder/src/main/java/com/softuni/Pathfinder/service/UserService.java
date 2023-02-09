package com.softuni.Pathfinder.service;

import com.softuni.Pathfinder.domain.dtos.banding.UserLoginForm;
import com.softuni.Pathfinder.domain.dtos.banding.UserRegisterForm;
import com.softuni.Pathfinder.domain.dtos.models.UserModel;
import com.softuni.Pathfinder.domain.entities.User;
import com.softuni.Pathfinder.helpers.LoggedUser;
import com.softuni.Pathfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final LoggedUser loggedUser;

    public UserService(ModelMapper modelMapper, UserRepository userRepository, RoleService roleService, LoggedUser loggedUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterForm userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRoles(this.userRepository.count() == 0
                ? this.roleService.findAllRoles()
                : Set.of(this.roleService.findRoleByName("USER")));

        final User userToSave = this.modelMapper.map(userModel, User.class);

        this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }

    public UserModel loginUser(UserLoginForm userLogin) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        UserModel userConfirmation = loginCandidate.isPresent()
                && loginCandidate.get().getPassword().equals(userLogin.getPassword())
                ? this.modelMapper.map(loginCandidate.get(), UserModel.class)
                : new UserModel();

        if (userConfirmation.isValid()){
            this.loggedUser
                    .setId(userConfirmation.getId())
                    .setUsername(userLogin.getUsername())
                    .setRoleModels(userConfirmation.getRoles());
        }

        return userConfirmation;
    }

    public void logout(){
        this.loggedUser.clearFields();
    }
}
