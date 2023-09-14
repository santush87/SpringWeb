package com.aleksandrov.battleShips.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserLoginDto {

    @NotBlank
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters.")
    private String username;

    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String password;

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
