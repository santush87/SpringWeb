package com.softuni.ResellerApp.model.dtos;

import com.softuni.ResellerApp.vallidation.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {
    @Size(min = 3, max = 20)
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    @Size(min = 3, max = 20)
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
}
