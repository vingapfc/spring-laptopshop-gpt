package com.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshop.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
