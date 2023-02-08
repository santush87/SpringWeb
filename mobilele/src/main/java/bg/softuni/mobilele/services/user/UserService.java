package bg.softuni.mobilele.services.user;


import bg.softuni.mobilele.domain.dtos.banding.UserLoginFormDto;
import bg.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.model.UserModel;

public interface UserService {
    UserModel registerUser(UserRegisterFormDto userRegister);

    void loginUser(UserLoginFormDto userLogin);

    void logout();
}