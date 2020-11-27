package com.ecommerce.service;

import com.ecommerce.data.models.Cart;

import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart);
    Cart updateCartDetails(Cart cart);
    List<Cart> findAllCarts();
    Cart findCartById(Integer id);
    void deleteCartById(Integer id);
}
