package com.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.laptopshop.repository.LaptopRepository;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/laptops/add")
    public String showAddForm(Model model) {
        model.addAttribute("laptop", new com.laptopshop.model.Laptop());
        return "laptop-form";
    }

    @PostMapping("laptops/save")
    public String saveLaptop(@ModelAttribute("laptop") com.laptopshop.model.Laptop laptop) {
        repository.save(laptop);
        return "redirect:/laptops";
    }

}
