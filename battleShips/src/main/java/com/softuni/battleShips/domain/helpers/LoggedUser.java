package com.softuni.battleShips.domain.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private String id;

    public boolean isEmpty(){
        return id.equals(null);
    }

    public void clearUser(){
        this.id = null;
    }
}
