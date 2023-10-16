package com.resellerapp.model.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterDto {

    @Size(min = 3, max = 20)
    private String username;

    @Email
    private String email;

//    @Size(min = 3, max = 20)
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
