package com.aleksandrov.battleShips.services;

import com.aleksandrov.battleShips.models.Ship;
import com.aleksandrov.battleShips.models.dtos.StartBattleDto;
import com.aleksandrov.battleShips.repositories.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {
    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDto attackData) {
        Optional<Ship> attackerOpt =
                this.shipRepository.findById((long) attackData.getAttackerId());
        Optional<Ship> defenderOpt =
                this.shipRepository.findById((long) attackData.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

        long newDefenderHealth = defender.getHealth() - attacker.getPower();

        if (defender.getHealth() <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(newDefenderHealth);
            this.shipRepository.save(defender);
        }


    }
}
