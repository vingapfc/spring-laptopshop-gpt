package com.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.laptopshop.repository.LaptopRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

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

    @PostMapping("/laptops/save")
    public String saveLaptop(@Valid @ModelAttribute("laptop") com.laptopshop.model.Laptop laptop,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "laptop-form";
        }
        repository.save(laptop);
        redirectAttributes.addFlashAttribute("successMessage", "Đã lưu thành công!");
        return "redirect:/laptops";
    }

    @GetMapping("/laptops/edit/{id}")
    public String editLaptop(@PathVariable Long id, Model model) {
        var laptop = repository.findById(id).orElse(null);
        model.addAttribute("laptop", laptop);
        return "laptop-form";
    }

    @GetMapping("/laptops/delete/{id}")
    public String deleteLaptop(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Đã xoá thành công!");
        return "redirect:/laptops";
    }

}
