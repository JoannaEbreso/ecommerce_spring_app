package com.ecommerce.service;

import java.util.List;

public interface CartItemService {
    CartItemService saveCartItem(CartItemService cartItem);
    CartItemService updateCartItemDetails(CartItemService cartItem);
    List<CartItemService> findAllCartItems();
    List<CartItemService> findAllCartItemsInACart(Integer cartId);
    void deleteById(Integer cartId);
}
