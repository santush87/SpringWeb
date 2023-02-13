package com.softuni.battleShips.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private String id;
    private String username;
    private String fullName;
    private String password;
    private String email;
}
