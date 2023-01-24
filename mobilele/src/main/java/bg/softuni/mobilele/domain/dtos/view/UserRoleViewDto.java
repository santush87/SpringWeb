package bg.softuni.mobilele.domain.dtos.view;

import bg.softuni.mobilele.domain.enums.RoleEnum;

public class UserRoleViewDto {

    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public UserRoleViewDto setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
