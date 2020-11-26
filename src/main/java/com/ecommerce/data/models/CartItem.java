package com.ecommerce.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Product product;

    private Integer quantity;

    private Double price;

    public void setPrice(Product product, Integer quantity) {
        price = product.getPrice() * quantity;
    }
}
