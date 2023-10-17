package com.plannerapp.model.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegisterDto {

    @Size(min = 3, max = 20)
    private String username;

    @Email
    private String email;

    @Size(min = 3, max = 20)
    private String password;
    private String confirmPassword;
}
