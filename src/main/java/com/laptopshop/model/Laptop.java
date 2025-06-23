package com.laptopshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Thương hiệu không được để trống")
    private String brand;

    @NotBlank(message = "Model không được để trống")
    private String model;

    @Min(value = 1, message = "Giá phải lớn hơn 0")
    @NotNull(message = "Model không được để trống")
    private Double price;

    public Laptop() {
    }

    public Laptop(String brand, String model, Double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
