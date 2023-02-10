package com.softuni.Pathfinder.domain.dtos.binding;

public class RoleChangeForm {

    private String roleName;

    public RoleChangeForm() {
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleChangeForm setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
