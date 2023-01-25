package bg.softuni.mobilele.domain.dtos.view;

import bg.softuni.mobilele.domain.enums.RoleEnum;

public class UserRoleViewDto {

    private String role;

    public String getRole() {
        return role;
    }

    public UserRoleViewDto setRole(String role) {
        this.role = role;
        return this;
    }
}
