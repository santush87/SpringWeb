package com.aleksandrov.battleShips.controllers;

import com.aleksandrov.battleShips.models.dtos.StartBattleDto;
import com.aleksandrov.battleShips.services.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {


    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDto startBattleDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(
                    "startBattleDto", startBattleDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.startBattleDto",
                    bindingResult);

            return "redirect:/home";
        }

        this.battleService.attack(startBattleDto);

        return "redirect:/home";
    }
}
