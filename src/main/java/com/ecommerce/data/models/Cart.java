package com.ecommerce.data.models;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CartItem> itemsInCart;

    private Double totalPrice;

    public void setItemsInCart(CartItem cartItem){
        if(cartItem != null){
            itemsInCart.add(cartItem);
        }
    }
}
