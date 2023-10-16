package com.resellerapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {

    @GetMapping("/offers/create")
    public ModelAndView create(){
        return new ModelAndView("offer-add");
    }
}
