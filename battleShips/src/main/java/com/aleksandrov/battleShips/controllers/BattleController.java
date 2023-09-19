package com.aleksandrov.battleShips.controllers;

import com.aleksandrov.battleShips.models.dtos.StartBattleDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BattleController {



    @PostMapping("/battle")
    public String battle(@Valid StartBattleDto startBattleDto) {

        System.out.println(startBattleDto.getAttackerId() +
                " " + startBattleDto.getDefenderId());

        return "redirect:/home";
    }
}
