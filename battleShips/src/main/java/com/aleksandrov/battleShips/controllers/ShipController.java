package com.aleksandrov.battleShips.controllers;

import com.aleksandrov.battleShips.models.dtos.CreateShipDto;
import com.aleksandrov.battleShips.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipServive;

    public ShipController(ShipService shipServive) {
        this.shipServive = shipServive;
    }

    @ModelAttribute("createShipDto")
    public CreateShipDto initCreateShipDto(){
        return new CreateShipDto();
    }

    @GetMapping("/ships/add")
    public String ships() {
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDto createShipDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.shipServive.create(createShipDto)) {
            redirectAttributes.addFlashAttribute(
                    "createShipDto",
                    createShipDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDto",
                    bindingResult);

            return "redirect:add";
        }
        return "redirect:/home";
    }
}
