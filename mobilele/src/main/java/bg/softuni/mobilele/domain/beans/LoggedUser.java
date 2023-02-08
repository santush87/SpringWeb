package bg.softuni.mobilele.domain.beans;

import bg.softuni.mobilele.domain.dtos.model.UserRoleModel;

public class LoggedUser {

    private String id;

    private String username;

    private UserRoleModel roleModel;

    public LoggedUser() {
    }

    public LoggedUser setId(String id) {
        this.id = id;
        return this;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public LoggedUser setRoleModel(UserRoleModel roleModel) {
        this.roleModel = roleModel;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public UserRoleModel getRoleModel() {
        return roleModel;
    }
}
