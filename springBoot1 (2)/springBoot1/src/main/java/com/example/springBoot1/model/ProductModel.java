package com.example.springBoot1.model;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "aa_products")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final  long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProducts;
    private String name;
    private BigDecimal valor;

    public ProductModel(UUID idProducts, String name, BigDecimal value) {
        this.idProducts = idProducts;
        this.name = name;
        this.valor = value;
    }

    public ProductModel() {
    }

    public UUID getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(UUID idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal value) {
        this.valor = value;
    }
}
