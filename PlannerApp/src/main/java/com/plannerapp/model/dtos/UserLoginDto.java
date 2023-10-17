package com.plannerapp.model.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UserLoginDto {

    @Size(min = 3, max = 20)
    private String username;

    private String password;
}
