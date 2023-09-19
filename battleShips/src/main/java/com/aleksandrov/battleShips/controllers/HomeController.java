package com.aleksandrov.battleShips.controllers;

import com.aleksandrov.battleShips.models.dtos.ShipDto;
import com.aleksandrov.battleShips.models.dtos.StartBattleDto;
import com.aleksandrov.battleShips.services.AuthService;
import com.aleksandrov.battleShips.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final AuthService authService;

    @ModelAttribute("startBattleDto")
    public StartBattleDto initStartBattleDto(){
        return new StartBattleDto();
    }

    public HomeController(ShipService shipService, AuthService authService) {
        this.shipService = shipService;
        this.authService = authService;
    }

    @GetMapping("/")
    public String loggedOutIndex(){
        if (this.authService.isLoggedIn()){
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model){
        if (!this.authService.isLoggedIn()){
            return "redirect:/";
        }

        long userId = this.authService.getLoggedUserId();

        List<ShipDto> ownShips = this.shipService.getShipsOwnedBy(userId);
        List<ShipDto> enemyShips = this.shipService.getShipsNotOwnedBy(userId);
        List<ShipDto> sortedShips = this.shipService.getAllSorted();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("sortedShips", sortedShips);
        return "home";
    }
}
