package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.helpers.LoggedUser;
import com.softuni.battleShips.domain.models.ShipModel;
import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.models.UserWithShipsModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {
    private final UserService userService;
    private final ShipService shipService;

    public BattleService(UserService userService, ShipService shipService) {
        this.userService = userService;
        this.shipService = shipService;
    }

    public UserWithShipsModel getUserWithShips(String id){
        UserModel userModel = this.userService.findById(id);
        List<ShipModel> allByUserId = this.shipService.findAllByUserId(id);

        return UserWithShipsModel.builder()
                .userModel(userModel)
                .shipModels(allByUserId)
                .build();
    }
}
