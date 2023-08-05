package br.com.aluraoracle.t5one.model;

import jakarta.persistence.Entity;

@Entity
public class ComputerProducts extends Product{
    private String brand;
    private Long model;

    public ComputerProducts() {
    }

    public ComputerProducts(String brand, Long model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }
}
