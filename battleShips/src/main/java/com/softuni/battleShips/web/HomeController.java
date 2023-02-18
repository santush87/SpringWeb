package com.softuni.battleShips.web;

import com.softuni.battleShips.domain.entities.Ship;
import com.softuni.battleShips.domain.helpers.LoggedUser;
import com.softuni.battleShips.domain.models.ShipModel;
import com.softuni.battleShips.domain.models.UserWithShipsModel;
import com.softuni.battleShips.domain.models.binding.BattleShipsModel;
import com.softuni.battleShips.domain.repositories.ShipRepository;
import com.softuni.battleShips.domain.services.BattleService;
import com.softuni.battleShips.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final BattleService battleService;
    private final UserService userService;
    private final ShipRepository shipRepository;

    public HomeController(LoggedUser loggedUser, BattleService battleService, UserService userService, ShipRepository shipRepository) {
        this.loggedUser = loggedUser;
        this.battleService = battleService;
        this.userService = userService;
        this.shipRepository = shipRepository;
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView modelAndView){

        UserWithShipsModel loggedUserWithShips = this.battleService
                .getUserWithShips(this.loggedUser.getId());
        UserWithShipsModel notLoggedUserWithShips = this.battleService
                .getUserWithShips(this.userService
                        .findByIdNot(this.loggedUser.getId())
                        .getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("loggedUserWithShips",loggedUserWithShips);
        modelAndView.addObject("notLoggedUserWithShips",notLoggedUserWithShips);

        return modelAndView;
    }

    @PostMapping("home")
    public String postHome(@ModelAttribute(name = "battleShipsModel") BattleShipsModel battleShipsModel){

        return "redirect:home";
    }

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @ModelAttribute(name = "battleShipsModel")
    public BattleShipsModel battleShipsModel(){
        return new BattleShipsModel();
    }

    @ModelAttribute(name = "allShips")
    public List<Ship> ships(){
        return this.shipRepository.findAll();
    }
}
