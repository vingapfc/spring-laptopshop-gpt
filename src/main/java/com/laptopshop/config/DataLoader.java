package com.laptopshop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laptopshop.repository.LaptopRepositery;

@Configuration
public class DataLoader {
    
    @Bean
    CommandLineRunner loadData(LaptopRepositery repo){
        return arg -> {
            
        }

        
    }

}
