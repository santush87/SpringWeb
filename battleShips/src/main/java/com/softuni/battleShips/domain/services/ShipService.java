package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.entities.Ship;
import com.softuni.battleShips.domain.helpers.LoggedUser;
import com.softuni.battleShips.domain.models.CategoryModel;
import com.softuni.battleShips.domain.models.ShipModel;
import com.softuni.battleShips.domain.models.UserModel;
import com.softuni.battleShips.domain.models.binding.ShipAddModel;
import com.softuni.battleShips.domain.repositories.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public boolean isThereShip(String shipName) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }

    public void addShip(ShipAddModel addModel) {
        UserModel theLoggedUser = this.userService.findById(this.loggedUser.getId());
        CategoryModel categoryModel = this.categoryService.findByName(addModel.getCategory());

        Ship shipToSave = this.modelMapper.map(new ShipModel().builder()
                .category(categoryModel)
                .created(addModel.getCreated())
                .name(addModel.getName())
                .health(addModel.getHealth())
                .power(addModel.getPower())
                .user(theLoggedUser)
                .build(), Ship.class);

        this.shipRepository.saveAndFlush(shipToSave);
    }

    public List<ShipModel> findAllByUserId(String id) {
        return this.shipRepository.findAllByUserId(id)
                .orElseThrow()
                .stream()
                .map(ship -> this.modelMapper.map(ship, ShipModel.class))
                .toList();
    }
}
