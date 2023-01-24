package bg.softuni.mobilele.services.role;

import bg.softuni.mobilele.domain.dtos.model.UserRoleDto;
import bg.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import bg.softuni.mobilele.domain.entities.UserRole;
import bg.softuni.mobilele.domain.enums.RoleEnum;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import bg.softuni.mobilele.services.init.DataBaseInitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService, DataBaseInitService {

    private final UserRoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public UserRoleServiceImpl(UserRoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
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

    public List<UserRoleViewDto> getAll(){
        return this.roleRepository.findAll()
                .stream()
                .map(role->this.modelMapper.map(role, UserRoleViewDto.class))
                .collect(Collectors.toList());
    }
}
