package io.github.andersonalexsandro.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank @Column(nullable = false)
    private String name;
    @Min(0)
    private double priece;
    @Min(0) @Max(1)
    private double discount;

    public Product() {
    }

    public Product(String name, double priece, double discount) {
        this.name = name;
        this.priece = priece;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriece() {
        return priece;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPriece(double priece) {
        this.priece = priece;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
