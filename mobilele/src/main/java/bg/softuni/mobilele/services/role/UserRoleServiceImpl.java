package bg.softuni.mobilele.services.role;

import bg.softuni.mobilele.domain.entities.UserRole;
import bg.softuni.mobilele.domain.enums.RoleEnum;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import bg.softuni.mobilele.services.init.DataBaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService, DataBaseInitService {

    private final UserRoleRepository roleRepository;
    @Autowired
    public UserRoleServiceImpl(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void dbInit() {
        List<UserRole> roles = new ArrayList<>();

        roles.add(new UserRole().setRole(RoleEnum.USER));
        roles.add(new UserRole().setRole(RoleEnum.ADMIN));

        this.roleRepository.saveAllAndFlush(roles);
    }

    @Override
    public boolean isDbInit() {
        return this.roleRepository.count() > 0;
    }

//    public List<UserRoleViewModel>
}
