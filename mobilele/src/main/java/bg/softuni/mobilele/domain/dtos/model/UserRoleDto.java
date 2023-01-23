package bg.softuni.mobilele.domain.dtos.model;

import bg.softuni.mobilele.domain.enums.RoleEnum;

public class UserRoleDto extends BaseEntityDto {

    private RoleEnum role;
    public RoleEnum getRole() {
        return role;
    }

    public UserRoleDto setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
