package com.laptopshop.config;

import com.laptopshop.model.Laptop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laptopshop.repository.LaptopRepositery;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(LaptopRepositery repo) {
        return args -> {
            repo.save(new Laptop("Dell", "Inspiron 15", 850.0));
            repo.save(new Laptop("HP", "Pavilion 14", 750.0));
            repo.save(new Laptop("Asus", "VivoBook X515", 690.0));
        };
    }
}
