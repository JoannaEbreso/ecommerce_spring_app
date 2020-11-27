package com.ecommerce.data.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date orderDate;

    private Date deliveryDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany
    private List<Product> product;

    @ManyToOne
    private Customer customer;
}
