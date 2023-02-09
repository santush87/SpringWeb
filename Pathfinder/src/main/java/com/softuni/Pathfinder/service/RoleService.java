package com.softuni.Pathfinder.service;

import com.softuni.Pathfinder.domain.dtos.models.RoleModel;
import com.softuni.Pathfinder.domain.enums.RoleName;
import com.softuni.Pathfinder.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;


    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public Set<RoleModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(role -> this.modelMapper.map(role, RoleModel.class))
                .collect(Collectors.toSet());
    }

    public RoleModel findRoleByName(String name) {
        return this.modelMapper.map(roleRepository.findByRole(RoleName.valueOf(name))
                .orElseThrow(NoSuchElementException::new),
                RoleModel.class);
    }
}
