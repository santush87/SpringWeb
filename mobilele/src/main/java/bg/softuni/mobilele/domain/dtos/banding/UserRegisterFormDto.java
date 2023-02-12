package bg.softuni.mobilele.domain.dtos.banding;

import bg.softuni.mobilele.domain.enums.RoleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterFormDto {

    @NotNull
    @Size(min = 2, max = 20)
    private String username;
    @NotNull
    @Size(min = 2, max = 20)
    private String password;
    @NotNull
    @Size(min = 2, max = 20)
    private String confirmPassword;
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @NotNull
    private RoleEnum role;

    public UserRegisterFormDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterFormDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterFormDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterFormDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterFormDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterFormDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public UserRegisterFormDto setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
