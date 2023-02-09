package com.softuni.Pathfinder.domain.dtos.models;

import com.softuni.Pathfinder.domain.enums.RoleName;

public class RoleModel {

    private RoleName role;

    public RoleModel() {
    }

    public RoleName getRole() {
        return role;
    }

    public RoleModel setRole(RoleName role) {
        this.role = role;
        return this;
    }
}
