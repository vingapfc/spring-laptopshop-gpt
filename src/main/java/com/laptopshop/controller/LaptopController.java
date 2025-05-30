package com.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptopshop.repository.LaptopRepository;

@Controller
public class LaptopController {
    private final LaptopRepository repository;

    private LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/laptops")
    public String listLaptops(Model model) {
        model.addAttribute("laptops", repository.findAll());
        return "laptops";
    }
}
