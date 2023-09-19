package com.aleksandrov.battleShips.services;

import com.aleksandrov.battleShips.enums.ShipType;
import com.aleksandrov.battleShips.models.Category;
import com.aleksandrov.battleShips.models.Ship;
import com.aleksandrov.battleShips.models.User;
import com.aleksandrov.battleShips.models.dtos.CreateShipDto;
import com.aleksandrov.battleShips.repositories.CategoryRepository;
import com.aleksandrov.battleShips.repositories.ShipRepository;
import com.aleksandrov.battleShips.repositories.UserRepository;
import com.aleksandrov.battleShips.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserSession session;
    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository,
                       ModelMapper modelMapper,
                       CategoryRepository categoryRepository,
                       UserSession session, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.session = session;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDto createShipDto) {
        Optional<Ship> optShip =
                this.shipRepository.findByName(createShipDto.getName());

        if (optShip.isPresent()) {
            return false;
        }

        ShipType typeName = switch (createShipDto.getCategory()){
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
            default -> ShipType.BATTLE;
        };

        Ship shipToSave = this.modelMapper.map(createShipDto, Ship.class);

        Category categoryToSave = this.categoryRepository.findByName(typeName);
        shipToSave.setCategory(categoryToSave);

        Optional<User> owner = this.userRepository.findById(this.session.getId());
        shipToSave.setUser(owner.get());

        this.shipRepository.save(shipToSave);

        return true;
    }
}
