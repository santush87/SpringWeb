package com.softuni.battleShips.domain.models.binding;

import com.softuni.battleShips.domain.validations.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 5, max = 20)
    @NotNull
    private String fullName;
    @Email
    @NotNull
    private String email;
    @Size(min = 3)
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;

}
