package com.ecommerce.data.repositories;

import com.ecommerce.data.models.Cart;
import com.ecommerce.data.models.CartItem;
import com.ecommerce.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void whenCartIsSaved_returnCardId(){
        cart.setTotalPrice(42000.50);

        assertThat(cart.getId()).isNull();
        cartRepository.save(cart);

        assertThat(cart.getId()).isNotNull();
    }

    @Test
    void mapCartItemToCartTest(){
        CartItem cartItem = new CartItem();
        Product product = productRepository.findById(2).orElse(null);
        cartItem.setProduct(product);
        cartItem.setQuantity(5);
        cartItem.setPrice(product,5);

        log.info("cart item before saving --> {}", cartItem);

        cartItemRepository.save(cartItem);

        log.info("cart item after saving --> {}", cartItem);

        cart = cartRepository.findById(1).orElse(null);

        assertThat(cart.getItemsInCart().size()).isEqualTo(0);

        cart.setItemsInCart(cartItem);
        cartRepository.save(cart);

        assertThat(cart.getItemsInCart().size()).isEqualTo(1);
    }

    @Test
    void updateCartTest(){
        cart = cartRepository.findById(3).orElse(null);
        assertThat(cart.getTotalPrice()).isEqualTo(15000.00);

        cart.setTotalPrice(25000.00);
        assertThat(cart.getTotalPrice()).isEqualTo(25000.00);
    }

    @Test
    void deleteCartTest(){
        cartRepository.deleteById(3);

        assertThat(cartRepository.existsById(3)).isFalse();
    }
}