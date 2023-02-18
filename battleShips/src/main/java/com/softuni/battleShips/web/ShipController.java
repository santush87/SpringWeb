package com.softuni.battleShips.web;

import com.softuni.battleShips.domain.models.binding.ShipAddModel;
import com.softuni.battleShips.domain.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String getAddShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String postAddShip(@Valid @ModelAttribute(name = "shipAddModel") ShipAddModel shipAddModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddModel", shipAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddModel",
                            bindingResult);

            return "redirect:add";
        }

        this.shipService.addShip(shipAddModel);

        return "redirect:/home";
    }

    @ModelAttribute(name = "shipAddModel")
    public ShipAddModel shipAddModel(){
        return new ShipAddModel();
    }
}
