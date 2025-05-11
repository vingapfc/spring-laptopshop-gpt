package com.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshop.model.Laptop;

public interface LaptopRepositery extends JpaRepository<Laptop, Long> {

}
