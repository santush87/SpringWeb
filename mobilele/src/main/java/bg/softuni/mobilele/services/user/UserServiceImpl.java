package bg.softuni.mobilele.services.user;

import bg.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.model.UserModel;
import bg.softuni.mobilele.domain.entities.UserEntity;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.services.init.DataBaseInitService;
import bg.softuni.mobilele.services.role.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements DataBaseInitService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }

    public UserModel registerUser(UserRegisterFormDto userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRole(this.userRepository.count() == 0
                ? this.userRoleService.findAllRoles()
                : List.of(this.userRoleService.findRoleByName("USER")));

        final UserEntity userEntityToSave = this.modelMapper.map(userModel, UserEntity.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userEntityToSave), UserModel.class);
    }

//    @Override
//    public void loginUser(UserLoginFormDto userLogin) {
//        UserModel loginCandidate =
//                this.modelMapper.map(this.userRepository.findByUsername(userLogin.getUsername()).get(),
//                        UserModel.class);
//
//        this.loggedUser
//                .setId(loginCandidate.getId())
//                .setUsername(loginCandidate.getUsername())
//                .setRoleModels(loginCandidate.getRole());
//    }
//
//    @Override
//    public void logout() {
//        this.loggedUser.clearFields();
//    }
}
